package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_OrdersDao;
import admin.vo.Admin_OrderVo;
@WebServlet("/admin/orders/list")
public class Admin_Orders_ListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Admin_OrdersDao dao=Admin_OrdersDao.getInstance();
		ArrayList<Admin_OrderVo> list=dao.ordelivery();//배송중
		ArrayList<Admin_OrderVo> list1=dao.ordelivery_completion();//배송완료
		ArrayList<Admin_OrderVo> list2=dao.orcomplete();//구매확정
		ArrayList<Admin_OrderVo> list3=dao.orcancle();//취소
		req.setAttribute("list", list);
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("content","/admin/admin_content/item/orders.jsp");
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
}
