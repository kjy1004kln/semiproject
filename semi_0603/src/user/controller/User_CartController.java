package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.User_CartDao;
import user.vo.User_CartVo;

@WebServlet("/user/cart")
public class User_CartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 여기로 넘어온것들 추가
		req.setCharacterEncoding("utf-8");
		// 아이디,등급,적립퍼센트,등급업까지남은돈,보유적립금,
		// 이미지,상품정보(사이즈,컬러),판매가,수량,적립금,배송비,합계
		// 총 결제에정금액,총 할인금액,총 적립금
		// 선택상품 삭제

		String pid = req.getParameter("pid");
		String[] orSize = req.getParameterValues("orSize");
		String[] orColor = req.getParameterValues("orColor");
		String[] amount = req.getParameterValues("amount");
		int leng = orSize.length;
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");

		// 장바구니에 추가
		// insert into cart values(cart_seq.nextval,'레드','S',3,'1234',1);
		for (int i = 0; i < leng; i++) {
			User_CartVo cartvo = new User_CartVo(0, orColor[i], orSize[i], Integer.parseInt(amount[i]), id,
					Integer.parseInt(pid));
			User_CartDao cartdao = new User_CartDao();
			int cdi = cartdao.addcart(cartvo);
			if (cdi < 1) {
				System.out.println("cartao오류");
			}
		}

		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/productDetail");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
