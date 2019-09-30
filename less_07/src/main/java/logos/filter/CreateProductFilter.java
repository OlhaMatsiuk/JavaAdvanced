package logos.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import logos.domain.RoleUser;
import logos.shared.FilterService;

@WebFilter("/createProduct.jsp")
public class CreateProductFilter implements Filter {
private FilterService filterService = FilterService.getFilterService();
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		filterService.doFilterValidation(request, response, chain, Arrays.asList(RoleUser.Admin));
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}