package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.CategoryDAO;
import vn.iotstar.dao.ProductDAO;
import vn.iotstar.model.CategoryModel;
import vn.iotstar.model.ProductModel;

@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// Lấy tham số từ JSP
		String categoryID = req.getParameter("cID");
		
		// Khởi tạo DAO
		ProductDAO productDAO = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
	
		// Sử dụng đối tượng list để chưa danh sách từ ProductDAO
		List<ProductModel> listProduct = productDAO.getAllProduct();
		ProductModel product = productDAO.getLastProduct();
		List<CategoryModel> listCategory = categoryDAO.getAllCategory();
		List<ProductModel> listProductByCategory = productDAO.getAllProductByCategory(categoryID);
						
		// Thiết lập dữ liệu lên JSP
		req.setAttribute("lastProduct", product);
		req.setAttribute("listCategories", listCategory);
		
		if(categoryID.equals("All")) {
			req.setAttribute("listAllProductByCategory", listProduct);
		}
		else {
			req.setAttribute("listAllProductByCategory", listProductByCategory);
		}

		
		// Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
