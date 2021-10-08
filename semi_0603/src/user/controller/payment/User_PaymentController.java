package user.controller.payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dao.UserProductDAO;
import user.dao.UserStockDAO;
import user.dao.User_MembersDao;
import user.dao.User_OrdersDao;
import user.dao.User_OrdersDetailDao;

@WebServlet("/user/payment")
public class User_PaymentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 결제내역에 추가하기.-결제테이블,결제세부테이블 완료
		// 결제가 완료되었습니다 창 뜨고 구매리스트 이동할 수 있는 버튼 만들기-완료
		// 마일리지 추가
		// 상품테이블에서 재고 빼기-완료
//		insert into orders values(ORDERS_seq.nextval,sysdate,'허지영','01052199755','경기 안양시 동안구 관평로 257경기 안양시 동안구 관양동 1586-5123호 (관양동)','15201',0,0,0,'N','N',null,'1234');
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		String pid = req.getParameter("pid");
		User_OrdersDao ordersdao = new User_OrdersDao();
		// 시퀀스 얻어오기
		int seq = ordersdao.selectseq();
		String[] saveDir = req.getParameterValues("saveDir");
		String[] newDir = req.getParameterValues("newDir");
		String[] upDir = req.getParameterValues("upDir");
		String allSum = req.getParameterValues("allSum")[0];
		String useMil1 = req.getParameter("useMil");
		int useMil = 0;
		if (!useMil1.equals("")) {
			useMil = Integer.parseInt(useMil1);
		}
		int ori = 0;
		if (!saveDir[2].isEmpty()) {
			ori = ordersdao.buyproduct(seq, saveDir[0], saveDir[2], saveDir[1], Integer.parseInt(allSum),
					Integer.parseInt(allSum) - useMil, id);
		} else if (!newDir[2].isEmpty()) {
			ori = ordersdao.buyproduct(seq, newDir[0], newDir[2], newDir[1], Integer.parseInt(allSum),
					Integer.parseInt(allSum) - useMil, id);
		} else if (!upDir[2].isEmpty()) {
			ori = ordersdao.buyproduct(seq, upDir[0], upDir[2], upDir[1], Integer.parseInt(allSum),
					Integer.parseInt(allSum) - useMil, id);
		}
		if (ori < 1) {
			System.out.println("ordersdao오류발생");
		}

// insert into order_detail(odid,odcolor,odsize,odcount,odmileage,orid,pid) values(1,'레드','s',1,0,18000,18000,1,1);
		User_OrdersDetailDao ordersdetaildao = new User_OrdersDetailDao();
		String[] orSize = req.getParameterValues("size");
		String[] orColor = req.getParameterValues("color");
		String[] amount = req.getParameterValues("amount");
		int leng = Integer.parseInt(req.getParameter("leng"));
		int odi = 0;
		for (int i = 0; i < leng; i++) {
			odi = ordersdetaildao.buyproduct(orColor[i], orSize[i], Integer.parseInt(amount[i]), seq,
					Integer.parseInt(pid));
			if (odi < 1) {
				System.out.println("ordersDetaildao오류발생");
				break;
			}
		}
//		update product set psell = psell+(select odcount from order_detail where pid=1) where pid=1;
		UserProductDAO userproductdao = new UserProductDAO();
		int upi = userproductdao.psellplus(seq, Integer.parseInt(pid));
		if (upi < 1) {
			System.out.println("userproductdao오류발생");
		}
//		update stock set samount= samount-(select odcount from order_detail where pid=1) where sid=(select sid from stock where sname=(select sname from stock where sid=(select sid from product where pid=1)) and scolor='레드' and ssize='S');
		UserStockDAO userstockdao = new UserStockDAO();
		for (int i = 0; i < leng; i++) {
			int usi = userstockdao.sellamount(seq, Integer.parseInt(pid), orColor[i], orSize[i]);
			if (usi < 1) {
				System.out.println("userstockdao오류발생");
			}
		}

		// 마일리지 추가해주기
		User_MembersDao usermembersdao = new User_MembersDao();
		String procuctMil = req.getParameter("addMileage");
		String per = req.getParameter("per");
		int userMil = useMil * (Integer.parseInt(per)) / 100;
		int addMil = Integer.parseInt(procuctMil) + userMil;
		int umi = usermembersdao.addMil(addMil, id);
		if (umi < 1) {
			System.out.println("usermembersdao오류발생");
		}
		req.setAttribute("top", "/user/user_content/header.jsp");
		req.setAttribute("content", "/user/user_content/user_board/purchaseOk.jsp");
		req.setAttribute("bottom", "/user/user_content/footer.jsp");

		req.getRequestDispatcher("/user/user_content/index.jsp").forward(req, resp);
	}
}
