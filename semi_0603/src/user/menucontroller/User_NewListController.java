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
@WebServlet("/user/new/list")
public class User_NewListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		User_MenuDao dao=User_MenuDao.getInstance();
		
		ArrayList<Admin_ProductVo2> list1=dao.newlist();//전체 상품
		
		req.setAttribute("list1",list1);
		String cp = req.getContextPath();
		ServletContext application = getServletContext();
		application.setAttribute("cp", cp);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/userInfo/usermenu/new.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
