package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import user.dao.User_MembersDao;
import user.vo.User_MembersVo;

@WebServlet("/user/address")
public class User_AddressController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		String addtitle=req.getParameter("addtitle");
		String addname=req.getParameter("addname");
		String addphone=req.getParameter("addphone");
		System.out.println(addtitle+addname+addphone);
		String addpostcode=req.getParameter("postcode");
		String roadAddress=req.getParameter("roadAddress");
		String jibunAddress=req.getParameter("jibunAddress");
		String detailAddress=req.getParameter("detailAddress");
		String extraAddress=req.getParameter("extraAddress");
		if(detailAddress==null || detailAddress=="") { //기타주소, 상세설명 없이도 insert가능하도록
			detailAddress=" ";
		}else if(extraAddress==null || extraAddress=="") {
			extraAddress=" ";
		}
		String allAddress=roadAddress+jibunAddress+detailAddress+extraAddress;
		User_MembersDao dao = new User_MembersDao();
		ArrayList<User_MembersVo> addlist=dao.list(id);
		req.setAttribute("addlist", addlist);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/userInfo/address.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		String addtitle=req.getParameter("addtitle");
		String addname=req.getParameter("addname");
		String addphone=req.getParameter("addphone");
		System.out.println(addtitle+addname+addphone);
		String addpostcode=req.getParameter("postcode");
		String roadAddress=req.getParameter("roadAddress");
		String jibunAddress=req.getParameter("jibunAddress");
		String detailAddress=req.getParameter("detailAddress");
		String extraAddress=req.getParameter("extraAddress");
		String allAddress=roadAddress+jibunAddress+detailAddress+extraAddress;
		System.out.println(allAddress);
		User_MembersDao dao = new User_MembersDao();
		User_MembersVo vo=new User_MembersVo(id,null,null,allAddress,addpostcode,null,null,null,0,0,null,addtitle,addname,addphone);
		int n=dao.addInsert(vo);
		ArrayList<User_MembersVo> addlist=dao.list(id);
		System.out.println(n);
		System.out.println(addlist);
		if(n>0) {
		req.setAttribute("addlist", addlist);
		req.setAttribute("addtitle", addtitle);
		req.setAttribute("addname", addname);
		req.setAttribute("addphone", addphone);
		req.setAttribute("postcode", addpostcode);
		req.setAttribute("roadAddress", roadAddress);
		req.setAttribute("jibunAddress", jibunAddress);
		req.setAttribute("detailAddress", detailAddress);
		req.setAttribute("extraAddress", extraAddress);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/userInfo/address.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		}
	}
}
