package admin.controller;

import java.io.IOException;
import java.net.http.HttpConnectTimeoutException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_MembersDao;
import admin.vo.Admin_MembersVo;
@WebServlet("/admin/main")
public class Admin_MainController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Admin_MembersDao dao=new Admin_MembersDao();
		ArrayList<Admin_MembersVo> list=dao.month();
		
		
		String content = (String)req.getAttribute("content");
		if(content==null) {
			content="/admin/admin_content/main.jsp";
		}
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		req.setAttribute("list", list);
		application.setAttribute("cp", cp);
		req.setAttribute("content", content);
		String cPath=req.getContextPath();
		req.setAttribute("content","/admin/admin_content/main.jsp");
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
}
