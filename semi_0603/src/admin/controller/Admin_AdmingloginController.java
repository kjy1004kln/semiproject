package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.dao.Admin_AdminDao;
import admin.vo.Admin_AdminVo;

@WebServlet("/admin/login")
public class Admin_AdmingloginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		System.out.println(id);
		System.out.println(pwd);
		
		Admin_AdminDao dao=new Admin_AdminDao();
		Admin_AdminVo vo=dao.getinfo(id);
		if(dao.getinfo(id)==null) {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/admin/admin_content/admin_login.jsp").forward(req, resp);
		}
		System.out.println(vo.getAid());
		System.out.println(vo.getApw());
		if(id.equals(vo.getAid()) && pwd.equals(vo.getApw())) {
			req.setAttribute("result", "success");
			req.getRequestDispatcher("/admin/main").forward(req, resp);
		}else if(!id.equals(vo.getAid()) && !pwd.equals(vo.getApw())){
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/admin/admin_content/admin_login.jsp").forward(req, resp);
		}
		HttpSession session=req.getSession();
		session.setAttribute("id", id);
	}
}
