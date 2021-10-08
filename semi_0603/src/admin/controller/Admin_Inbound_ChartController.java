package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_ChartDao;
import admin.vo.Admin_InboundVo;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/inbound/chart.do")
public class Admin_Inbound_ChartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin_ChartDao dao=Admin_ChartDao.getInstacne();
		ArrayList<Admin_StockVo> list=dao.underlist();
		ArrayList<Admin_InboundVo> list1=dao.categorylist();
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		for(Admin_StockVo vo:list) {
			pw.print("<comm>");
			pw.print("<sname>"+vo.getSname()+"</sname>");
			pw.print("<samount>"+vo.getSamount()+"</samount>");
			pw.print("</comm>");
		}
		for(Admin_InboundVo vo:list1) {
			pw.print("<comm1>");
			pw.print("<incategory>"+vo.getIncategory()+"</incategory>");
			pw.print("<inamount>"+vo.getInamount()+"</inamount>");
			pw.print("</comm1>");
		}
		pw.print("</result>");
	}
}
