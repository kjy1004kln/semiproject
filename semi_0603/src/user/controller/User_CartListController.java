package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.UserProductDAO;
import user.dao.UserStockDAO;
import user.dao.User_CartDao;
import user.dao.User_GradeDao;
import user.dao.User_MembersDao;
import user.vo.UserStockVo;
import user.vo.User_CartVo;
import user.vo.User_GradeVo;
import user.vo.User_MembersVo;
import user.vo.User_ProductVo;

@WebServlet("/user/cartList")
public class User_CartListController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User_CartDao cartdao = new User_CartDao();
		UserProductDAO productdao = new UserProductDAO();
		UserStockDAO stockdao = new UserStockDAO();
		User_MembersDao memberdao = new User_MembersDao();
		User_GradeDao gradedao = new User_GradeDao();
		ArrayList<User_CartVo> list = cartdao.cartList();
		ArrayList<Integer> pidlist = new ArrayList<>();
		ArrayList<User_ProductVo> productlist = new ArrayList<>();
		ArrayList<UserStockVo> stocklist = new ArrayList<>();
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		for (int i = 0; i < list.size(); i++) {
			int pid = list.get(i).getPid();
			User_ProductVo productvo = productdao.productDetail(pid);
			UserStockVo stockvo = stockdao.stockDetail(productvo.getSid());
			pidlist.add(pid);
			productlist.add(productvo);
			stocklist.add(stockvo);
		}
		int allPay=0;
		int allSale=0;
		for (int i = 0; i < list.size(); i++) {
			allPay += productlist.get(i).getPprice() * list.get(i).getCamount();
			allSale += productlist.get(i).getPprice() * productlist.get(i).getPdiscount() / 100 * list.get(i).getCamount();
		}
		int resultPay = allPay-allSale;
		User_MembersVo membervo = memberdao.findInfo(id);
		User_GradeVo gradevo = gradedao.getGrade(id);
		int per = 0;
		if (gradevo.getGlevel().equals("friend")) {
			per = 1;
		}
		if (gradevo.getGlevel().equals("family")) {
			per = 3;
		}
		if (gradevo.getGlevel().equals("vip")) {
			per = 5;
		}
		if (gradevo.getGlevel().equals("vvip")) {
			per = 7;
		}
		int leng = stocklist.size();
		req.setAttribute("allPay", allPay);
		req.setAttribute("allSale", allSale);
		req.setAttribute("resultPay", resultPay);
		req.setAttribute("leng", leng);
		req.setAttribute("membervo", membervo);
		req.setAttribute("gradevo", gradevo);
		req.setAttribute("per", per);
		req.setAttribute("list", list);
		req.setAttribute("pidlist", pidlist);
		req.setAttribute("productlist", productlist);
		req.setAttribute("stocklist", stocklist);
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/cart.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
