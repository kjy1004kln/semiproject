package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_StockDao;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/stock/find")
public class Admin_Stock_FindController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Admin_StockDao dao=Admin_StockDao.getInstance();
		int sid=Integer.parseInt(req.getParameter("sid"));
		Admin_StockVo vo=dao.selectsid(sid);
		PrintWriter pw=resp.getWriter();
		pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pw.print("<result>");
		pw.print("<code>success</code>");
		pw.print("<code>fail</code>");
		pw.print("</result>");
	}
}
