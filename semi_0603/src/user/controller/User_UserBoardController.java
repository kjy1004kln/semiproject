package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_UserBoardDao;
import user.vo.UserQnaVo;
import user.vo.User_ReviewVo;

@WebServlet("/user/userBoard")
public class User_UserBoardController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		String field = req.getParameter("field");

		String keyword = req.getParameter("keyword");
		String spageNum = req.getParameter("pageNum");
		int pageNum = 1;
		if (spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		
		String spageNum0 = req.getParameter("pageNum0");
		int pageNum0 = 1;
		if (spageNum0 != null) {
			pageNum0 = Integer.parseInt(spageNum0);
		}

		User_UserBoardDao dao = new User_UserBoardDao();
		int startRow = (pageNum - 1) * 10 + 1;
		int endRow = startRow + 9;
		int startRow0 = (pageNum0 - 1) * 10 + 1;
		int endRow0 = startRow0 + 9;
		
		ArrayList<UserQnaVo> qlist = dao.qlist(id,startRow, endRow, field, keyword);
		int pageCount = (int) Math.ceil(dao.getCount(id,field, keyword) / 10.0);
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
		int endPageNum = startPageNum + 9;
		if (endPageNum > pageCount) {
			endPageNum = pageCount;
		}
		ArrayList<User_ReviewVo> Rlist = dao.Rlist(id ,startRow0, endRow0);
		int pageCount0 = (int) Math.ceil(dao.getCount0(id) / 10.0);
		int startPageNum0 = ((pageNum0 - 1) / 10 * 10) + 1;
		int endPageNum0 = startPageNum0 + 9;
		if (endPageNum0 > pageCount0) {
			endPageNum0 = pageCount0;
		}
		ArrayList<UserQnaVo> list = dao.list(id ,startRow, endRow);
		req.setAttribute("list", list);
		req.setAttribute("Rlist", Rlist);
		req.setAttribute("Qlist", qlist);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("pageCount0", pageCount0);
		req.setAttribute("startPageNum0", startPageNum0);
		req.setAttribute("endPageNum0", endPageNum0);
		req.setAttribute("pageNum0", pageNum0);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/userInfo/UserBoard.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		
	}
}
