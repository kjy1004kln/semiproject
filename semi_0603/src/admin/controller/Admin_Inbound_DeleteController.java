package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_InboundDao;
import admin.dao.Admin_StockDao;
import admin.vo.Admin_InboundVo;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/inbound/delete")
public class Admin_Inbound_DeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int inid=Integer.parseInt(req.getParameter("inid"));
		Admin_InboundDao dao=Admin_InboundDao.getInstance();
		Admin_InboundVo vo1=dao.selectinid(inid);
		int n=dao.delete(inid);
		
		//stock 재고 목록 삭제
		String inname=vo1.getInname();
		String incolor=vo1.getIncolor();
		String insize=vo1.getInsize();
		int inamount=vo1.getInamount();
		
		int sid=0;
		String sname=null;
		String scolor=null;
		String ssize=null;
		int samount=0;
		Admin_StockDao stdao=Admin_StockDao.getInstance();
		ArrayList<Admin_StockVo> stlist=stdao.list();
		for(int i=0;i<stlist.size(); i++) {
			sid=stlist.get(i).getSid();
			sname=stlist.get(i).getSname();
			scolor=stlist.get(i).getScolor();
			ssize=stlist.get(i).getSsize();
			samount=stlist.get(i).getSamount();
			if(inname.equals(sname) && incolor.equals(scolor) && insize.equals(ssize)) {
				int sum=samount-inamount;
				if(sum==0) {
					stdao.delete(sid);
				}else {
					Admin_StockVo stvo1=new Admin_StockVo(sid, sname, scolor, ssize, sum,0);
					stdao.update(stvo1);
				}
			}
		}
		
		
		if(n>0) {
			String cPath=req.getContextPath();
			resp.sendRedirect(cPath+"/admin/inbound/list");
		}else {
			req.setAttribute("result", "fail");
			req.setAttribute("content","/admin/admin_content/item/inbound.jsp");
			req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
		}
	}
}
