package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_OrdersDao;
@WebServlet("/admin/orders/completeupdate")
public class Admin_Orders_Orcomplete_UpdateConroller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orid=Integer.parseInt(req.getParameter("orid"));
		Admin_OrdersDao dao=Admin_OrdersDao.getInstance();
		int n=dao.orcomplete_update(orid);
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/orders/list");
	}
}
