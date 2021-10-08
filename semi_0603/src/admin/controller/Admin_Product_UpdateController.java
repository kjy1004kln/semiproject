package admin.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.dao.Admin_ProductDao;
import admin.vo.Admin_ProductVo;
@WebServlet("/admin/product/update")
public class Admin_Product_UpdateController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDir=getServletContext().getRealPath("/img");
		MultipartRequest mr=new MultipartRequest(req, 
				saveDir,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		int pid=Integer.parseInt(mr.getParameter("pid"));
		Admin_ProductDao dao=Admin_ProductDao.getInstance();
		Admin_ProductVo vo=dao.getimage(pid);
		System.out.println(vo.getPimage1());
		//기존 이미지 삭제
		File f1=new File(vo.getPimage1());
		f1.delete();
		File f2=new File(vo.getPimage2());
		f2.delete();
		
		int pprice=Integer.parseInt(mr.getParameter("pprice"));
		int pdiscount=Integer.parseInt(mr.getParameter("pdiscount"));
		String orgpimage1=mr.getOriginalFileName("pimage1");
		String pimage1=mr.getFilesystemName("pimage1");
		String image1=saveDir + "/" + pimage1;
		String orgpimage2=mr.getOriginalFileName("pimage2");
		String pimage2=mr.getFilesystemName("pimage2");
		String image2=saveDir + "/" + pimage2;
		
		
		Admin_ProductVo vo1=new Admin_ProductVo(pid, pprice, pdiscount, image1, image2, null, pdiscount, 0);
		int n=dao.update(vo1);
		if(n>0) {
			req.setAttribute("code", "success");
		}else {
			req.setAttribute("code", "fail");
		}
		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/admin/product/list");
	}
}
