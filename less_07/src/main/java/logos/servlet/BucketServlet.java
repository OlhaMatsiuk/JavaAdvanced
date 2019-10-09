package logos.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logos.domain.Bucket;
import logos.domain.Magazine;
import logos.domain.User;
import logos.service.BucketService;
import logos.service.MagazineService;
import logos.service.UserService;
import logos.service.impl.BucketServiceImpl;
import logos.service.impl.MagazineServiceImpl;
import logos.service.impl.UserServiceImpl;

@WebServlet("/bucket" )
public class BucketServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	private UserService userService = UserServiceImpl.getUserService();
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		
		Magazine magazine = magazineService.read(Integer.parseInt(productId));
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		User user = userService.read(userId);
		
		Bucket bucket = new Bucket();
		
		bucket.setMagazine(magazine);
		bucket.setUser(user);
		bucket.setPurchaseDate(new Date());
		
		bucketService.create(bucket);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
