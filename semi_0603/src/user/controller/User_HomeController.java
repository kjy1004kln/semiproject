package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.vo.Admin_ProductVo2;
import user.dao.User_MenuDao;

@WebServlet("/user/home")
public class User_HomeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_MenuDao dao = User_MenuDao.getInstance();
		ArrayList<Admin_ProductVo2> list = dao.mainbest8();
		ArrayList<Admin_ProductVo2> list1 = dao.mainlist();

		String top = (String) req.getAttribute("top");
		String content = (String) req.getAttribute("content");
		String bottom = (String) req.getAttribute("bottom");
		if (top == null) {
			top = "/user/user_content/header.jsp";
		}
		if (content == null) {
			// content="/user/main";
			content = "/user/user_content/main.jsp";
		}
		if (bottom == null) {
			bottom = "/user/user_content/footer.jsp";
		}
		req.setAttribute("list", list);
		req.setAttribute("list1", list1);
		req.setAttribute("top", top);
		req.setAttribute("content", content);
		req.setAttribute("bottom", bottom);

		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
