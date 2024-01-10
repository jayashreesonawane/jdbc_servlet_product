package jdbc_servlet_product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Double price = Double.parseDouble(req.getParameter("price"));
		String brand = req.getParameter("brand");
		String state = req.getParameter("state");
		
		Product product = new Product();
		
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setState(state);
		
		ServletContext context = getServletContext();
		double cgst = Double.parseDouble(context.getInitParameter("CGST"));
		double sgst=0;
		if (state.equals("MH")) 
		{
			ServletConfig config = getServletConfig();
			sgst = Double.parseDouble(config.getInitParameter("MH"));
		} 
		else if(state.equals("AP"))
		{
			ServletConfig config = getServletConfig();
			sgst = Double.parseDouble(config.getInitParameter("AP"));
		}
		else
		{
			ServletConfig config = getServletConfig();
			sgst = Double.parseDouble(config.getInitParameter("TN"));
		}
		price += (cgst+sgst)*price;
		product.setPrice(price);
		
		ProductCRUD crud = new ProductCRUD();
		try 
		{
			int result = crud.saveProduct(product);
			if (result !=0) 
			{
//				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.html");
//				dispatcher.forward(req, resp);
				resp.sendRedirect("https://www.google.com/");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
