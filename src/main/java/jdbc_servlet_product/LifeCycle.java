package jdbc_servlet_product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")					//annotation

public class LifeCycle extends HttpServlet {

	public LifeCycle() {
		System.out.println("Instantiation is done");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init() method is called");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() method is called");
	}

	@Override
	public void destroy() {
		System.out.println("destroy() method is called");
	}

}
