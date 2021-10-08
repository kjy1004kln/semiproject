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
import admin.vo.Admin_ProductVo;
import user.vo.UserQnaVo;
import user.vo.User_MembersVo;
@WebServlet("/admin/main/chart.do")
public class Admin_MainChartController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin_ChartDao dao=Admin_ChartDao.getInstacne();
		//ArrayList<Admin_InboundVo> list=dao.inbound_2020();
		//ArrayList<Admin_ProductVo> list1=dao.product_2020();
		ArrayList<User_MembersVo> list2=dao.joinmember();//총가입자
		ArrayList<User_MembersVo> list3=dao.adultmember();//성인
		ArrayList<User_MembersVo> list4=dao.minormember();//미성년
		UserQnaVo vo1=dao.qlist(0);
		UserQnaVo vo2=dao.qlist(1);
		
		resp.setContentType("text/xml;charset=utf-8");
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
//		for(Admin_InboundVo vo:list) {
//			pw.print("<comm>");
//			pw.print("<inprice>"+vo.getInprice()+"</inprice>");
//			pw.print("</comm>");
//		}
//		for(Admin_ProductVo vo:list1) {
//			pw.print("<comm1>");
//			pw.print("<pprice>"+vo.getPprice()+"</pprice>");
//			pw.print("</comm1>");
//		}
		for(User_MembersVo vo:list2) {
			pw.print("<comm3>");
			pw.print("<mmileage>"+vo.getMmileage()+"</mmileage>");//총가입자
			pw.print("</comm3>");
		}
		for(User_MembersVo vo:list3) {
			pw.print("<comm4>");
			pw.print("<mmileage1>"+vo.getMmileage()+"</mmileage1>");//성인
			pw.print("</comm4>");
		}
		for(User_MembersVo vo:list4) {
			pw.print("<comm5>");
			pw.print("<mmileage2>"+vo.getMmileage()+"</mmileage2>");//성인
			pw.print("</comm5>");
		}
		pw.print("<qnatext>");
		pw.print("<qid>"+vo1.getQid()+"</qid>");//미처리
		pw.print("<qid1>"+vo2.getQid()+"</qid1>");//처리
		pw.print("</qnatext>");
		
		pw.print("</result>");
	}
}
