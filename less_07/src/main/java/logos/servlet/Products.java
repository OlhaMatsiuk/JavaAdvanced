package logos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import logos.domain.Magazine;
import logos.service.MagazineService;
import logos.service.impl.MagazineServiceImpl;

@WebServlet(name = "products", urlPatterns = { "/products" })
public class Products extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MagazineService magazineService = MagazineServiceImpl.getMagazineService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Magazine> products = magazineService.readAll();
		String json = new Gson().toJson(products);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
}
