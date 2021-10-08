package user.controller;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_MembersDao;
import user.vo.User_MembersVo;

@WebServlet("/user/update")
public class User_updateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/userInfo/updatePassCk.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String mid=(String)session.getAttribute("id"); //login 컨트롤러에서 session 저장된 것 꺼내오기
		String mpw=(String)session.getAttribute("pwd"); 
		User_MembersDao dao=new User_MembersDao();
		String newpw=req.getParameter("newpw");
		String mname=req.getParameter("mname");
		String mphone=req.getParameter("mphone");
		String memail=req.getParameter("memail");
		
		Date indate=null;
	    try{
	        String mbirth1=req.getParameter("mbirth");
	        System.out.println(mbirth1);
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	        indate=(Date)sdf.parse(mbirth1); 
	    }catch (Exception e) {
	       e.printStackTrace();
	    }
	    java.sql.Date mbirth = new java.sql.Date(indate.getTime()); //sql.date로 넣어야 들어감
		    User_MembersVo vo2=new User_MembersVo(mid,newpw,mname,null,null,mphone,null,mbirth,0,0,memail,null,null,null);
			int n=dao.updateInfo(vo2);
			if(n>0) {
				session.invalidate();
				req.getRequestDispatcher("/user/home").forward(req, resp);
			}

		}
	}

