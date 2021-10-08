package admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.Admin_ProductDao;
import admin.dao.Admin_StockDao;
import admin.vo.Admin_StockVo;
@WebServlet("/admin/product/delete")
public class Admin_Product_DeleteController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		int sid=Integer.parseInt(req.getParameter("sid"));
		String pimage1=req.getParameter("pimage1");
		String pimage2=req.getParameter("pimage2");
		String uploadPath=getServletContext().getRealPath("/img");
		File f1=new File(uploadPath+"\\"+pimage1);
		f1.delete();
		File f2=new File(uploadPath+"\\"+pimage2);
		f2.delete();
		
		Admin_ProductDao dao=Admin_ProductDao.getInstance();
		int n=dao.delete(pid);
		Admin_StockDao dao1=Admin_StockDao.getInstance();
		Admin_StockVo vo=dao1.selectsid(sid);
		int n1=dao1.updatelev2(vo.getSname());
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/product/list");
	}
}
