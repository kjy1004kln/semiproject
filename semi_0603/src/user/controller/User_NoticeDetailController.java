package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.User_NoticeDao;
import user.vo.User_NoticeVo;

@WebServlet("/user/noticedetail")
public class User_NoticeDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid = req.getParameter("fid");
		User_NoticeDao dao = new User_NoticeDao();
		User_NoticeVo vo = dao.noticeDetail(fid);
		User_NoticeVo back = dao.backNotice(fid);
		User_NoticeVo next = dao.nextNotice(fid);
		req.setAttribute("vo", vo);
		req.setAttribute("back", back);
		req.setAttribute("next", next);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/noticeDetail.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
		
	}
}
