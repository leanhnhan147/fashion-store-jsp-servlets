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

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// Khởi tạo DAO
		ProductDAO productDAO = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();
	
		// Sử dụng đối tượng list để chưa danh sách từ ProductDAO
		List<ProductModel> list4Product = productDAO.getTop4Product();
		List<ProductModel> list4BestSeller = productDAO.getTop4BestSeller();
		List<ProductModel> list1BestSellerAndNew = productDAO.getTop1BestSellerAndNew();
		List<CategoryModel> listCategory = categoryDAO.getAllCategory();
						
		// Thiết lập dữ liệu lên JSP
		req.setAttribute("listTop4Product", list4Product);
		req.setAttribute("listTop4BestSeller", list4BestSeller);
		req.setAttribute("listTop1BestSellerAndNew", list1BestSellerAndNew);
		req.setAttribute("listCategories", listCategory);
		
		// Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
