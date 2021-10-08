package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_ProductDao;
import admin.dao.Admin_StockDao;
import admin.vo.Admin_ProductVo;
import admin.vo.Admin_ProductVo2;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/product/list")
public class Admin_Product_ListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//재고리스트
		Admin_StockDao dao=Admin_StockDao.getInstance();
		ArrayList<Admin_StockVo> list=dao.agglist();
		req.setAttribute("list", list);
		
		//판매등록된 리스트
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		Admin_ProductDao dao1=Admin_ProductDao.getInstance();
		int startRow=(pageNum-1)*6+1;
		int endRow=startRow+5;
		ArrayList<Admin_ProductVo> list1=dao1.list(startRow, endRow, field, keyword);
		int pageCount=(int)Math.ceil(dao1.getCount(field, keyword)/6.0);
		int startPageNum=((pageNum-1)/6*6)+1;
		int endPageNum=startPageNum+5;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		
		//이미지 출력
		Admin_ProductVo2 vo2=dao1.img();
		
		req.setAttribute("vo2", vo2);
		req.setAttribute("vo1", req.getAttribute("vo1"));
		req.setAttribute("list1", list1);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("content","/admin/admin_content/item/product.jsp");
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
}
