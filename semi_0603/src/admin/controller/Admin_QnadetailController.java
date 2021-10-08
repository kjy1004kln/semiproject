package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserQnaDAO;
import user.vo.UserQnaVo;

@WebServlet("/admin/qnadetail")
public class Admin_QnadetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int qid=Integer.parseInt(req.getParameter("qid"));
		UserQnaDAO dao=new UserQnaDAO();
		UserQnaVo vo=dao.detail(qid);
		String content=vo.getQcontent();
		content=content.replaceAll("\n","<br>");
		vo.setQcontent(content);
		
		req.setAttribute("vo",vo);
		
		req.getRequestDispatcher("/admin/admin_content/board/qnareply.jsp").forward(req, resp);
	}
}
