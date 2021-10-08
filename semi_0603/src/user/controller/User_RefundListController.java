package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_OrdersDao;
import user.vo.UserOrderlistVo;

@WebServlet("/user/refund")
public class User_RefundListController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		User_OrdersDao dao = new User_OrdersDao();
		
		int n=dao.CountOrid(id);
		if(n>0) {
			req.setAttribute("Countorid", n);
		}
		
		ArrayList<UserOrderlistVo> refundList=dao.refundList(id, startdate, enddate);
		int pageCount=(int)Math.ceil(dao.getCountref()/10.0);
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount; //endPageNum값을 pageCount값으로 초기화
		}
		req.setAttribute("refundList", refundList);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startdate", startdate);
		req.setAttribute("enddate", enddate);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/purchaseList.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
