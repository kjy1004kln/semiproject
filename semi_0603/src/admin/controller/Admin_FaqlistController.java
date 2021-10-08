package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_AdminDao;
import admin.dao.Admin_FaqDao;
import admin.vo.Admin_AdminVo;
import admin.vo.Admin_FaqVo;

@WebServlet("/admin/faq/list")
public class Admin_FaqlistController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		String spageNum=req.getParameter("pageNum");
		
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		
		Admin_FaqDao dao=new Admin_FaqDao();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ArrayList<Admin_FaqVo> list=dao.publiclist(startRow, endRow,field,keyword);
		int pageCount=(int)Math.ceil(dao.getCountpublic(field,keyword)/10.0);		
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list",list);
		req.setAttribute("pageCount",pageCount);
		req.setAttribute("startPageNum",startPageNum);
		req.setAttribute("endPageNum",endPageNum);
		req.setAttribute("pageNum",pageNum);
		req.setAttribute("content","/admin/admin_content/board/faqlist.jsp");
		req.setAttribute("field",field);
		req.setAttribute("keyword",keyword);
		
		req.setCharacterEncoding("utf-8");
		String field1=req.getParameter("field1");
		String keyword1=req.getParameter("keyword1");
		String spageNum1=req.getParameter("pageNum1");
		
		int pageNum1=1;
		if(spageNum1!=null) {
			pageNum1=Integer.parseInt(spageNum1);
		}
		
		Admin_FaqDao dao1=new Admin_FaqDao();
		int startRow1=(pageNum1-1)*10+1;
		int endRow1=startRow1+9;
		ArrayList<Admin_FaqVo> list1=dao1.privatelist(startRow1, endRow1,field1,keyword1);
		int pageCount1=(int)Math.ceil(dao1.getCountprivate(field1,keyword1)/10.0);		
		int startPageNum1=((pageNum1-1)/10*10)+1;
		int endPageNum1=startPageNum1+9;
		if(endPageNum1>pageCount1) {
			endPageNum1=pageCount1;
		}
		
		req.setAttribute("list1",list1);
		req.setAttribute("pageCount1",pageCount1);
		req.setAttribute("startPageNum1",startPageNum1);
		req.setAttribute("endPageNum1",endPageNum1);
		req.setAttribute("pageNum1",pageNum1);
		req.setAttribute("content","/admin/admin_content/board/faqlist.jsp");
		req.setAttribute("field1",field1);
		req.setAttribute("keyword1",keyword1);
		
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
}
