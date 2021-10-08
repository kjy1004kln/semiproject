package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_FaqDao;
import admin.vo.Admin_FaqVo;

@WebServlet("/admin/faqpopup")
public class Admin_faqpopupController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid=req.getParameter("fid");
		Admin_FaqDao dao=new Admin_FaqDao();
		Admin_FaqVo vo= dao.detail(Integer.parseInt(fid));
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/admin/admin_content/board/faqlistupdate.jsp").forward(req, resp);
	}
}
