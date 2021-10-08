package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_FaqDao;
import admin.dao.Admin_NoticeDao;
import admin.vo.Admin_FaqVo;

@WebServlet("/admin/noticepopup")
public class Admin_NoticepopupController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid=req.getParameter("fid");
		Admin_NoticeDao dao=new Admin_NoticeDao();
		Admin_FaqVo vo= dao.detail(Integer.parseInt(fid));
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/admin/admin_content/board/noticelistupdate.jsp").forward(req, resp);
	}
}
