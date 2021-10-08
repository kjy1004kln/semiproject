package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_MembersDao;
import user.vo.User_MembersVo;

@WebServlet("/user/addUpdate")
public class User_AddupdateController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		String addtitle=req.getParameter("addtitle");
		String addname=req.getParameter("addname");
		String addphone=req.getParameter("addphone");
		String addpostcode=req.getParameter("postcode");
		String roadAddress=req.getParameter("roadAddress");
		String jibunAddress=req.getParameter("jibunAddress");
		String detailAddress=req.getParameter("detailAddress");
		String extraAddress=req.getParameter("extraAddress");
		if(detailAddress==null || detailAddress=="") { //기타주소, 상세설명 없이도 update가능하도록
			detailAddress=" ";
		}else if(extraAddress==null || extraAddress=="") {
			extraAddress=" ";
		}
		String allAddress=roadAddress+jibunAddress+detailAddress+extraAddress;
		User_MembersDao dao = new User_MembersDao();
		User_MembersVo vo=new User_MembersVo(id,null,null,allAddress,addpostcode,null,null,null,0,0,null,addtitle,addname,addphone);
		int n=dao.updateAdd(vo);
		User_MembersDao mdao = new User_MembersDao();
		ArrayList<User_MembersVo> addlist=mdao.list(id);
		if(n>0) {
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("addlist", addlist);
		req.setAttribute("content","/user/user_content/user_board/userInfo/address.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		}
	}
}
