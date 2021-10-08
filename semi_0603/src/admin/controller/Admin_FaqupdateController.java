package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_FaqDao;
import admin.vo.Admin_FaqVo;

@WebServlet("/admin/faq/update")
public class Admin_FaqupdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int fid=Integer.parseInt(req.getParameter("fid"));
		String fwriter=req.getParameter("fwriter");
		String ftitle=req.getParameter("ftitle");
		String fcontent=req.getParameter("fcontent");
		int fpublic_private=Integer.parseInt(req.getParameter("fpublic_private"));
		
		Admin_FaqDao dao=new Admin_FaqDao();
		Admin_FaqVo vo=new Admin_FaqVo(fid, ftitle, fcontent,null,0, fpublic_private,fwriter);
		dao.update(vo);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/admin/admin_content/board/popupclose.jsp").forward(req, resp);
	}
}
