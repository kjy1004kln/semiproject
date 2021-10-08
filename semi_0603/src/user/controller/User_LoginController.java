package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_MembersDao;
import user.vo.User_MembersVo;
@WebServlet("/user/login")
public class User_LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/userInfo/login.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
	
	@Override //로그인
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");

	//	HttpServletRequest req=(HttpServletRequest)request;
		User_MembersDao dao= new User_MembersDao();
		int check=dao.findaccount(id,pwd);
		User_MembersVo vo=dao.findInfo(id);
		HttpSession session=req.getSession();
		System.out.println(check);

		if(check==1) {
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			session.setAttribute("mname", vo.getMname());//update.jsp 에서 스크립트릿으로 값 불러올때 사용할 것
			session.setAttribute("mphone",vo.getMphone());
			session.setAttribute("memail",vo.getMemail());
			session.setAttribute("mmileage",vo.getMmileage());
			req.getRequestDispatcher("/user/home").forward(req, resp);
		}else {
			req.setAttribute("errMsg", "아이디 또는 비밀번호가 맞지 않습니다");
			req.setAttribute("top", "/user/user_content/header.jsp");
			req.setAttribute("content","/user/user_content/user_board/userInfo/login.jsp");
			req.setAttribute("bottom", "/user/user_content/footer.jsp");
			req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		}
	}
}
