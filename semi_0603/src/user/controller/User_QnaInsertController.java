package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.dao.UserQnaDAO;
import user.vo.UserQnaVo;

@WebServlet("/user/qnainsert")
public class User_QnaInsertController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String saveDir=getServletContext().getRealPath("/qnaimage");
		MultipartRequest mr=new MultipartRequest(req, // request객체
				saveDir,  //업로드할 디렉토리 경로
				1024*1024*5, // 최대 업로드 크기(바이트)
				"utf-8", //인코딩방식
				new DefaultFileRenamePolicy()//동일한 파일명이 존재할시 파일명뒤에 일련번호(1,2,3,..)을 붙여서 파일 생성
		);		
		
		String mid=mr.getParameter("mid");
		String qcate=mr.getParameter("qcate");
		String qtitle=mr.getParameter("qtitle");
		String qcontent=mr.getParameter("qcontent");
		String qpw=mr.getParameter("qpw");
		//String orgFileName=mr.getOriginalFileName("file1");//전송된 파일명
		String saveFileName=mr.getFilesystemName("file1");//서버에 저장된 파일명
		String fpath= "/qnaimage/" + saveFileName;
		UserQnaDAO dao=new UserQnaDAO();
		UserQnaVo vo=new UserQnaVo(0, qcate, qpw, qtitle, qcontent, fpath, null, 0, 0, 0, mid, 1);
		dao.insert(vo);
		//큐엔에이 테스트				
		req.setAttribute("vo", vo);

		String cPath=req.getContextPath();
		resp.sendRedirect(cPath+"/user/qna");
	}
}
