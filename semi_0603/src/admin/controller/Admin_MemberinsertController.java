package admin.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_MembersDao;
import admin.vo.Admin_MembersVo;

@WebServlet("/admin/memberinsert")
public class Admin_MemberinsertController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("content", "/admin/admin_content/member/memberinsert.jsp");
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String year=req.getParameter("year");
		String month=req.getParameter("month");
		String day=req.getParameter("day");
		
		String mid=req.getParameter("mid");
		String mpw=req.getParameter("mpw");
		String mname=req.getParameter("mname");
		String maddress=req.getParameter("maddress");
		String mpost=req.getParameter("mpost");
		String mphone=req.getParameter("mphone");
		String memail=req.getParameter("memail");
		
		String from = year+"-"+month+"-"+day;
		Date mbirth=null;
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			mbirth=(Date)sdf.parse(from);
		}catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(mbirth.getTime());
		
		
		Admin_MembersDao dao=new Admin_MembersDao();
		Admin_MembersVo vo=new Admin_MembersVo(mid, mpw, mname, maddress, mpost, mphone, null, sqlDate, 0, 1000, memail,null,null,null);
				
		dao.insert(vo);
		
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/memberlist");
		
	}
}
