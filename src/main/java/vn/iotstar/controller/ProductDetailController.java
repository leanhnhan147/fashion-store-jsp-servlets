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

@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// Lấy tham số từ JSP
		String productID = req.getParameter("pID");
		String categoryID = req.getParameter("cID");
		// Khởi tạo DAO
		ProductDAO productDAO = new ProductDAO();
		CategoryDAO categoryDAO = new CategoryDAO();

		// Sử dụng đối tượng list để chưa danh sách từ ProductDAO			
		ProductModel product = productDAO.getProductByID(productID);
		
		List<CategoryModel> listCategoryByID = categoryDAO.getAllCategoryByID(categoryID);
		
		List<CategoryModel> listCategory = categoryDAO.getAllCategory();

		// Thiết lập dữ liệu lên JSP
		req.setAttribute("productDetail", product);
		req.setAttribute("categoryDetail", listCategoryByID.get(0));
		
		req.setAttribute("listCategories", listCategory);
		
		// Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/views/productdetail.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	
}
