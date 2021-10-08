package user.menucontroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.vo.Admin_ProductVo2;
import user.dao.User_MenuDao;
@WebServlet("/user/acc/list")
public class User_AccListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String spageNum=req.getParameter("pageNum");
		int pageNum=1;
		if(spageNum!=null) {
			pageNum=Integer.parseInt(spageNum);
		}
		int startRow=(pageNum-1)*16+1;
		int endRow=startRow+15;
		
		User_MenuDao dao=User_MenuDao.getInstance();
		ArrayList<Admin_ProductVo2> list=dao.accbest4();//베스트
		
		int pageCount=(int)Math.ceil(dao.accgetCount()/16.0);
		ArrayList<Admin_ProductVo2> list1=dao.acclist(startRow, endRow);//전체 상품
		int startPageNum=((pageNum-1)/16*16)+1;
		int endPageNum=startPageNum+15;
		if(endPageNum>pageCount) {
			endPageNum=pageCount;
		}
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		
		req.setAttribute("list",list);
		req.setAttribute("list1",list1);
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/userInfo/usermenu/acc.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
