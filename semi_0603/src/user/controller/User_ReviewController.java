package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import user.dao.User_OrdersDao;
import user.dao.User_ReviewDao;
@WebServlet("/user/review")
public class User_ReviewController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String saveDir=getServletContext().getRealPath("/img");
		MultipartRequest mr=new MultipartRequest(req, 
				saveDir,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		String savepimage2=mr.getFilesystemName("fupload");
		String rphoto1=saveDir + "/" + savepimage2;
		String rtitle=mr.getParameter("rtitle");
		System.out.println(rtitle);
		String rcontent=mr.getParameter("rcontent");
		System.out.println(rcontent);
		int sid=Integer.parseInt(mr.getParameter("sid"));
		HttpSession session=req.getSession();
		String id=(String)session.getAttribute("id");
		
		User_ReviewDao dao = new User_ReviewDao();
		User_OrdersDao dao1=new User_OrdersDao();
		int n=dao.insertReview(id,rtitle,rcontent, rphoto1,sid);
		int n1=dao1.CountOrid(id);
		if(n1>0) {
			req.setAttribute("Countorid", n);
		}
		req.getRequestDispatcher("/user/user_content/user_board/closePopup.jsp").forward(req, resp);
	}
}
