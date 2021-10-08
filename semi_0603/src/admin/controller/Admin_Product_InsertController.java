package admin.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.dao.Admin_ProductDao;
import admin.dao.Admin_StockDao;
import admin.vo.Admin_ProductVo;
import admin.vo.Admin_ProductVo2;
import admin.vo.Admin_StockVo;

@WebServlet("/admin/product/upload")
public class Admin_Product_InsertController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir=getServletContext().getRealPath("/img");
		MultipartRequest mr=new MultipartRequest(req, 
				saveDir,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		int pprice=Integer.parseInt(mr.getParameter("pprice"));
		int pdiscount=Integer.parseInt(mr.getParameter("pdiscount"));
		String orgpimage1=mr.getOriginalFileName("pimage1");
		String savepimage1=mr.getFilesystemName("pimage1");
		String image1=saveDir + "/" + savepimage1;
		String orgpimage2=mr.getOriginalFileName("pimage2");
		String savepimage2=mr.getFilesystemName("pimage2");
		String image2=saveDir + "/" + savepimage2;
		String sname=mr.getParameter("sname");
		
		Admin_ProductDao dao=Admin_ProductDao.getInstance();
		Admin_ProductVo2 vo=new Admin_ProductVo2(0, pprice, pdiscount, image1, image2, null, 0, 0, sname, null, null);
		int n=dao.insert(vo);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		Admin_StockDao stdao=Admin_StockDao.getInstance();
		int n1=stdao.updatelev(sname);
		if(n1>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/product/list");
	}
}
