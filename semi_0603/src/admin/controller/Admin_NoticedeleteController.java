package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_NoticeDao;


@WebServlet("/admin/notice/delete")
public class Admin_NoticedeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int fid=Integer.parseInt(req.getParameter("fid"));
		
		Admin_NoticeDao dao=new Admin_NoticeDao();
		dao.delete(fid);
		
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/notice/list");
	}
}
