package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frame.Biz;
import com.user.UserBiz;
import com.vo.User;

import web.dispatcher.Navi;
import web.dispatcher.UI;

@WebServlet({ "/UserServlet", "/user" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<String, User> biz;

	public UserServlet() {
		biz = new UserBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		if (view != null) {
			UI.build(request, view); // view:useradd
		} else if (cmd != null) {
			if (cmd.equals("useraddimpl")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");

				try {
					biz.register(new User(id, name, pwd));
					request.setAttribute("rid", id);
					UI.build(request, cmd);
					// next = "user/rok";
				} catch (Exception e) {
					e.printStackTrace();
					// next = "user/rfail";
					request.setAttribute("navi", Navi.useraddf);
					request.setAttribute("center", "user/rfail");
				}
			} else if (cmd.equals("userlist")) {
				ArrayList<User> list = null;
				try {
					list = biz.get();
					request.setAttribute("ulist", list);
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (cmd.equals("userdetail")) {
				String id = request.getParameter("id");
				User user = null;
				try {
					user = biz.get(id);
					request.setAttribute("ud", user);
					// next = "user/detail";
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("delete")) {
				String id = request.getParameter("id");
				try {
					biz.remove(id);
					response.sendRedirect("user.do?cmd=userlist");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("userupdate")) {
				String id = request.getParameter("id");
				User user = null;
				try {
					user = biz.get(id);
					request.setAttribute("uu", user);
					//next = "user/update";
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("updateimpl")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				try {
					biz.modify(new User(id, pwd, name));
					response.sendRedirect("user.do?cmd=userdetail&id="+id);
					return;
				} catch (Exception e) {
					e.printStackTrace();
					// next = "user/rfail";
					request.setAttribute("navi", Navi.userupdatef);
					request.setAttribute("center", "user/rfail");
				}
			}
		}
			
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
