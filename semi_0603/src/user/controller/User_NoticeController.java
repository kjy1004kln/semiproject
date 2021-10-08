package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.User_NoticeDao;
import user.vo.User_NoticeVo;

@WebServlet("/user/notice")
public class User_NoticeController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String field = req.getParameter("field");
		String spageNum = req.getParameter("pageNum");
		String keyword = null;
		int pageNum = 1;
		User_NoticeDao dao = new User_NoticeDao();
		ArrayList<User_NoticeVo> list = new ArrayList<>();
		if (field == null || field.equals("")) {
			if (spageNum != null) {
				pageNum = Integer.parseInt(spageNum);
			}
			int startRow = 10 * pageNum - 9;
			int endRow = pageNum * 10;
			list = dao.noticeList(startRow, endRow);
		} else {
			keyword = req.getParameter("keyword");
			req.setAttribute("find", field);
			req.setAttribute("keyword", keyword);
			int startRow = 10 * pageNum - 9;
			int endRow = pageNum * 10;
			list = dao.findList(field, keyword, startRow, endRow);
		}
		int pageCount = (int) Math.ceil(dao.getCount(field, keyword) / 10.0);
		int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
		int endPageNum = startPageNum + 9;
		if (endPageNum > pageCount) {
			endPageNum = pageCount;
		}

		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/notice.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
