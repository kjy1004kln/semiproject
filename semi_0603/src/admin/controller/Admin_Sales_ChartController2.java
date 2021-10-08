package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_ChartDao;
import admin.vo.Admin_InboundVo;
import admin.vo.Admin_ProductVo;
@WebServlet("/admin/sales/chart2.do")
public class Admin_Sales_ChartController2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year=req.getParameter("year");
		String fryear=year+"-01-01";
		String endyear=year+"-12-31";
		Admin_ChartDao dao=Admin_ChartDao.getInstacne();
		ArrayList<Admin_InboundVo> list=dao.inbound_year(fryear, endyear);
		ArrayList<Admin_ProductVo> list1=dao.product_year(fryear, endyear);
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(Admin_InboundVo vo:list) {
			pw.print("<comm>");
			pw.print("<inprice>"+vo.getInprice()+"</inprice>");
			pw.print("</comm>");
		}
		for(Admin_ProductVo vo:list1) {
			pw.print("<comm1>");
			pw.print("<pprice>"+vo.getPprice()+"</pprice>");
			pw.print("</comm1>");
		}
		pw.print("</result>");
		
	}
}
