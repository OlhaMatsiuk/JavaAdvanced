package logos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logos.domain.Magazine;
import logos.service.MagazineService;
import logos.service.impl.MagazineServiceImpl;

@WebServlet("/product")
public class MagazineServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MagazineService magazineService = MagazineServiceImpl.getMagazineService();
	
	//create
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name = request.getParameter("name");
			String category = request.getParameter("category");
			String price = request.getParameter("price");
			String publishDate = request.getParameter("publishDate");
		
			Magazine magazine  = new Magazine(name, category, getValidatedPrice(price), Integer.parseInt( publishDate));
			magazineService.create(magazine );
			response.setContentType("text");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Success");
		}
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	private  double getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

}
