package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import admin.dao.Admin_InboundDao;
import admin.dao.Admin_StockDao;
import admin.vo.Admin_InboundVo;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/inbound/insert")
public class Admin_inbound_InsertController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Date indate=null;
		try{
			String indate1=req.getParameter("indate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			indate=(Date)sdf.parse(indate1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(indate.getTime());
		
		String inname=req.getParameter("inname");
		String inprice1=req.getParameter("inprice");
		int inprice=Integer.parseInt(inprice1);
		String inamount1=req.getParameter("inamount");
		int inamount=Integer.parseInt(inamount1);
		String incolor=req.getParameter("incolor");
		String insize=req.getParameter("insize");
		String incategory=req.getParameter("incategory");
		
		
		boolean check=false;
		int sid=0;
		String sname=null;
		String scolor=null;
		String ssize=null;
		int samount=0;
		Admin_StockDao dao=Admin_StockDao.getInstance();
		ArrayList<Admin_StockVo> stlist=dao.list();
		for(int i=0;i<stlist.size(); i++) {
			sname=stlist.get(i).getSname();
			scolor=stlist.get(i).getScolor();
			ssize=stlist.get(i).getSsize();
			samount=stlist.get(i).getSamount();
			if(inname.equals(sname) && incolor.equals(scolor) && insize.equals(ssize)) {
				check=true;
				sid=stlist.get(i).getSid();
			}
		}
		if(check==true) {
			int amount=samount+inamount;
			Admin_StockVo stvo=new Admin_StockVo(sid, inname, incolor, insize, amount,0);
			int n1=Admin_StockDao.getInstance().update(stvo);
		}else {
			Admin_StockVo stvo1=new Admin_StockVo(0, inname, incolor, insize, inamount,0);
			int n2=Admin_StockDao.getInstance().insert(stvo1);
		}
		
		Admin_InboundVo vo=new Admin_InboundVo(0, sqlDate, inname, inprice, inamount, incolor, insize, incategory);
		int n3 = Admin_InboundDao.getInstance().insert(vo);
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/inbound/list");
		
	}
}
