package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.dao.UserProductDAO;
import user.dao.UserQnaDAO;
import user.dao.UserStockDAO;
import user.dao.User_OrdersDao;
import user.dao.User_ReviewDao;
import user.vo.UserQnaVo;
import user.vo.UserStockVo;
import user.vo.User_ProductReview;
import user.vo.User_ProductVo;
import user.vo.User_ReviewVo;

@WebServlet("/user/productDetail")
public class User_ProductDetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pid = req.getParameter("pid");
		UserProductDAO dao = new UserProductDAO();
		User_ProductVo vo = dao.productDetail(Integer.parseInt(pid));
		UserStockDAO stockDao = new UserStockDAO();
		UserStockVo stockVo = stockDao.stockDetail(vo.getSid());
		ArrayList<String> colorList = stockDao.chooseColor(stockVo.getSname());
		UserQnaDAO userDao = new UserQnaDAO();
		UserQnaVo userVo = userDao.productQnaList(vo.getPid());
		
		//상세페이지 리뷰 목록
				HttpSession session=req.getSession();
				String id=(String)session.getAttribute("id");
				String keyword = req.getParameter("keyword");
				String spageNum = req.getParameter("pageNum");

				int pageNum = 1;
				if (spageNum != null) {
					pageNum = Integer.parseInt(spageNum);
				}
				
				User_ReviewDao dao1=new User_ReviewDao();
				int startRow = (pageNum - 1) * 10 + 1;
				int endRow = startRow + 9;
				
				ArrayList<User_ProductReview> PDRlist = dao1.PDRlist(stockVo.getSname(),startRow, endRow);
				int pageCount = (int) Math.ceil(dao1.getCount(id) / 10.0);
				int startPageNum = ((pageNum - 1) / 10 * 10) + 1;
				int endPageNum = startPageNum + 9;
				if (endPageNum > pageCount) {
					endPageNum = pageCount;
				}

		req.setAttribute("vo", vo);
		req.setAttribute("userVo", userVo);
		req.setAttribute("stockVo", stockVo);
		req.setAttribute("colorList", colorList);
		req.setAttribute("PDRlist", PDRlist);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("startPageNum", startPageNum);
		req.setAttribute("endPageNum", endPageNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("keyword", keyword);
		
		
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/productDetail.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
