package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserQnaDAO;
import user.vo.UserQnaVo;

@WebServlet("/user/qnapwdcheck")
public class User_QnaPwdCheckController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwdcheck=req.getParameter("pwdcheck");
		String qid=req.getParameter("qid");
		
		System.out.println(qid);
		UserQnaDAO dao=new UserQnaDAO();
		UserQnaVo vo=dao.detail(Integer.parseInt(qid));
		if(!pwdcheck.equals(vo.getQpw())) {
			req.setAttribute("result", "fail");
			req.getRequestDispatcher("/user/user_content/user_board/qnapwdcheck.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("vo", vo);
			
			req.setAttribute("top", "/user/user_content/header.jsp");
			req.setAttribute("content", "/user/user_content/user_board/qnadetail.jsp");
			req.setAttribute("bottom", "/user/user_content/footer.jsp");
			req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		}
	}
}
