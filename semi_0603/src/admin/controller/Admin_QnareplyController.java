package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserQnaDAO;
import user.vo.UserQnaVo;

@WebServlet("/admin/qna/reply")
public class Admin_QnareplyController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String qid=req.getParameter("qid");
		String qcate=req.getParameter("qcate");
		String qpw=req.getParameter("qpw");
		String qtitle=req.getParameter("qtitle");
		String qcontent=req.getParameter("qcontent");
		String qfile=req.getParameter("qfile");
		
		String mid=req.getParameter("mid");
		int pid=Integer.parseInt(req.getParameter("pid"));
		int qid1=0;
		int ref=0;
		int lev=0;

		if(qid!=null && !qid.equals("")) {
			qid1=Integer.parseInt(qid);
			ref=Integer.parseInt(req.getParameter("ref"));
			lev=Integer.parseInt(req.getParameter("lev"));
		}
		UserQnaVo vo=new UserQnaVo(qid1, qcate, qpw, qtitle, qcontent, qfile, null, lev, ref, lev, mid, pid);
				
		UserQnaDAO dao=new UserQnaDAO();
		dao.reply(vo);
		
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/admin/admin_content/board/popupclose.jsp").forward(req, resp);
	}
}
