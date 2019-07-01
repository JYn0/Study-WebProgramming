package web.dispatcher;

import javax.servlet.http.HttpServletRequest;

public class UI {
	// make ui
	public static void build(HttpServletRequest request, String view){
		if(view.equals("login")) {
			request.setAttribute("navi", Navi.login);
			request.setAttribute("center", "login");
		}else if(view.equals("register")) {
			request.setAttribute("navi", Navi.register);
			request.setAttribute("center", "register");
		}else if(view.equals("aboutus")) {
			request.setAttribute("navi", Navi.aboutus);
			request.setAttribute("center", "aboutus");
		}else if(view.equals("useradd")) {
			request.setAttribute("navi", Navi.useradd);
			request.setAttribute("center", "user/add");
		}else if(view.equals("userlist")) {
			request.setAttribute("navi", Navi.userlist);
			request.setAttribute("center", "user/list");
		}else if(view.equals("productadd")) {
			request.setAttribute("navi", Navi.productadd);
			request.setAttribute("center", "product/add");
		}
		
	}
}

