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
import com.oreilly.servlet.MultipartRequest;
import com.product.ProductBiz;
import com.vo.Product;
import com.vo.User;

import web.dispatcher.Navi;
import web.dispatcher.UI;

@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Biz<Integer, Product> biz;
	
	public ProductServlet() {
		biz = new ProductBiz();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = request.getParameter("view");
		String cmd = request.getParameter("cmd");
		String next = "main.jsp";
		if(view != null) {
			UI.build(request, view); 
		}else if(cmd != null) {
			if(cmd.equals("productaddimpl")) {
				MultipartRequest mr = new MultipartRequest(request, "C:\\web\\day1333\\web\\img", 1024*1024*100, "UTF-8");
				String name = mr.getParameter("name");
				String price = mr.getParameter("price");
				String imgname = mr.getOriginalFileName("imgname");
				try {
					biz.register(new Product(name, Double.parseDouble(price), imgname));
					// next = "product/pok";
					UI.build(request, cmd);
				}catch (Exception e) {
					// next = "product/pfail";
					e.printStackTrace();
					request.setAttribute("navi", Navi.productaddf);
					request.setAttribute("center", "product/pfail");
				}
			}else if(cmd.equals("productlist")) {
				//next = "product/list";
				ArrayList<Product> list = null;
				try {
					list = biz.get();
					request.setAttribute("plist", list);
					// next = "product/list";
					UI.build(request, cmd);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("productdetail")) {
				String id = request.getParameter("id");
				try {
					Product p = null;
					p = biz.get(Integer.parseInt(id));
					request.setAttribute("p", p);
					// next = "product/detail";
					UI.build(request, cmd);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("delete")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				try {
					biz.remove(id);
					response.sendRedirect("product.do?cmd=productlist");
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("update")) {
				Integer id = Integer.parseInt(request.getParameter("id"));
				
				try {
					Product p = null;
					p = biz.get(id);
					request.setAttribute("pu", p);
					UI.build(request, cmd);
					// next = "product/update";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(cmd.equals("updateimpl")) {
				MultipartRequest mr = new MultipartRequest(request, "C:\\web\\day1333\\web\\img", 1024*1024*100, "UTF-8");
				String id = mr.getParameter("id");
				String name = mr.getParameter("name");
				String price = mr.getParameter("price");
				String imgname = mr.getParameter("imgname");
				String newimgname = mr.getOriginalFileName("newimgname");
				
				if(newimgname == null || newimgname.equals("")) {
					try {
						biz.modify(new Product(Integer.parseInt(id), name, Double.parseDouble(price), imgname));
					} catch (Exception e) {
						e.printStackTrace();
						// next = "product/pfail";
						request.setAttribute("navi", Navi.updatef);
						request.setAttribute("center", "product/pfail");
					}
				}else {
					try {
						biz.modify(new Product(Integer.parseInt(id), name, Double.parseDouble(price), newimgname));
					} catch (Exception e) {
						e.printStackTrace();
						// next = "product/pfail";
						request.setAttribute("navi", Navi.updatef);
						request.setAttribute("center", "product/pfail");
					}
				}
				
				response.sendRedirect("product.do?cmd=productdetail&id="+id);
				return;

			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
