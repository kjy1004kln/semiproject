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

import admin.dao.Admin_NoticeDao;
import admin.vo.Admin_NoticeVo;


@WebServlet("/admin/notice/insert")
public class Admin_NoticeinsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String saveDir=getServletContext().getRealPath("/noticeimage");
		MultipartRequest mr=new MultipartRequest(req, // request객체
				saveDir,  //업로드할 디렉토리 경로
				1024*1024*5, // 최대 업로드 크기(바이트)
				"utf-8", //인코딩방식
				new DefaultFileRenamePolicy()//동일한 파일명이 존재할시 파일명뒤에 일련번호(1,2,3,..)을 붙여서 파일 생성
		);
		String fwriter=mr.getParameter("fwriter");
		String ftitle=mr.getParameter("ftitle");
		String fcontent=mr.getParameter("fcontent");
		fcontent = fcontent.replace("\r\n", "<br>");
		int fpublic_private=Integer.parseInt(mr.getParameter("fpublic_private"));
		System.out.println("업로드 경로:" + saveDir);
		String orgFileName=mr.getOriginalFileName("file1");//전송된 파일명
		String saveFileName=mr.getFilesystemName("file1");//서버에 저장된 파일명
		System.out.println("orgFileName:" + orgFileName);
		System.out.println("saveFileName:" + saveFileName);
		
		
		//File f=mr.getFile("file1"); //업로드된 파일에 대한 정보를 갖는 파일객체 
		String fpath= "/noticeimage/" + saveFileName;
		
		Admin_NoticeDao dao=new Admin_NoticeDao();
		Admin_NoticeVo vo=new Admin_NoticeVo(0, ftitle, fcontent,fpath,null,0, fpublic_private,fwriter);
		dao.insert(vo);
		
		req.setAttribute("vo", vo);
		
		String cPath=req.getContextPath();
		req.getRequestDispatcher("/admin/admin_content/board/popupclose.jsp").forward(req, resp);
	}
}
