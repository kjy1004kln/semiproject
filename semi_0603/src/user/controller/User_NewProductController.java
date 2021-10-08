package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserProductDAO;
import user.dao.UserStockDAO;
import user.vo.User_ProductVo;

@WebServlet("/user/new")
public class User_NewProductController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserProductDAO productdao = new UserProductDAO();
		UserStockDAO stockDao = new UserStockDAO();
		ArrayList<User_ProductVo> list = new ArrayList<>();
		list = productdao.newList();
		ArrayList<String> nameList = new ArrayList<>();
		for (User_ProductVo vo : list) {
			String name = stockDao.sid(vo.getSid());
			nameList.add(name);
		}
		req.setAttribute("list", list);
		req.setAttribute("nameList", nameList);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/new.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");
		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
