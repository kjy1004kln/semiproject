package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_InboundDao;
import admin.vo.Admin_InboundVo;
@WebServlet("/admin/inbound/select")
public class Admin_Inbound_SelectController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int inid=Integer.parseInt(req.getParameter("inid"));
		Admin_InboundDao dao=Admin_InboundDao.getInstance();
		Admin_InboundVo vo=dao.selectinid(inid);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<comm>");
		pw.print("<inname>"+vo.getInname()+"</inname>");
		pw.print("<incolor>"+vo.getIncolor()+"</incolor>");
		pw.print("<insize>"+vo.getInsize()+"</insize>");
		pw.print("<incategory>"+vo.getIncategory()+"</incategory>");
		pw.print("<indate>"+vo.getIndate()+"</indate>");
		pw.print("<inprice>"+vo.getInprice()+"</inprice>");
		pw.print("<inamount>"+vo.getInamount()+"</inamount>");
		pw.print("</comm>");
		pw.print("</result>");
	}
}
