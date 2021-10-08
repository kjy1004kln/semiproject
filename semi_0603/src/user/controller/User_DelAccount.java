package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_MembersDao;

@WebServlet("/user/delaccount")
public class User_DelAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String mid=(String)session.getAttribute("id");
		String mpw=(String)session.getAttribute("pwd"); 
		
		req.setCharacterEncoding("utf-8");
		User_MembersDao dao=new User_MembersDao();
		int n=dao.delAccount(mid);
//		if(n>0) {
//			req.setAttribute("code", "success");
//		}else {
//			req.setAttribute("code", "fail");
//		}
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/main.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
