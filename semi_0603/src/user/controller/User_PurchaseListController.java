package user.controller;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_OrdersDao;
import user.vo.UserOrderlistVo;

@WebServlet("/user/purchase")
public class User_PurchaseListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String startdate=req.getParameter("startdate");
		String enddate=req.getParameter("enddate");
		String spageNum=req.getParameter("pageNum");
		String field=req.getParameter("field");
		System.out.println("field:"+field);
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
//		int sid=Integer.parseInt(req.getParameter("sid"));
//		String sname=req.getParameter("sname");
//		String odcolor=req.getParameter("odcolor");
//		String odsize=req.getParameter("odsize");
		User_OrdersDao dao = new User_OrdersDao();
		int startRow=10*pageNum-9;
		int endRow=pageNum*10;
		
		int n=dao.CountOrid(id);
		if(n>0) {
			req.setAttribute("Countorid", n);
		}
		ArrayList<UserOrderlistVo> OrderList=dao.OrderList(startRow, endRow, field, id, startdate, enddate);
		int pageCount=(int)Math.ceil(dao.getCount(field)/10.0);
		System.out.println("OrderList:"+OrderList);
		ArrayList<UserOrderlistVo> refundList=dao.refundList(id, startdate, enddate);

		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount; //endPageNum값을 pageCount값으로 초기화
		}
		//User_ReviewDao dao1=new User_ReviewDao();
		//int n1=dao1.checkReview(id, sid, sname, odcolor, odsize);
		//req.setAttribute("checkReview", n1);
		req.setAttribute("refundList", refundList);
		req.setAttribute("OrderList", OrderList);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startdate", startdate);
		req.setAttribute("enddate", enddate);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content","/user/user_content/user_board/purchaseList.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
