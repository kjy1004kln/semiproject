package admin.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserQnaDAO;
import user.vo.UserQnaVo;

@WebServlet("/admin/qna")
public class Admin_QnalistController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String field=req.getParameter("field");
		String keyword=req.getParameter("keyword");
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		
		UserQnaDAO dao=new UserQnaDAO();
		int startRow=(pageNum-1)*10+1;
		int endRow=startRow+9;
		ArrayList<UserQnaVo> list=dao.all_list(startRow, endRow, field, keyword);
		int pageCount=(int)Math.ceil(dao.getCount(field, keyword)/10.0);
		int startPageNum=((pageNum-1)/10*10)+1;
		int endPageNum=startPageNum+9;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("list", list);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("field", field);
		req.setAttribute("keyword", keyword);
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("content","/admin/admin_content/board/qna.jsp");
		req.getRequestDispatcher("/admin/admin_content/index.jsp").forward(req, resp);
	}
}
