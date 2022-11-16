package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.ProductModel;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	// Hiển thị 4 sản phẩm mới nhất
	public List<ProductModel> getTop4Product() {
		// Khai báo List để lưu danh sách SP
		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn
		String sql = "select TOP 4 * \r\n" + "from Product \r\n" + "order by ProductID DESC";
		try {
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}

		return list;
	}

	// Hiển thị 4 sản phẩm bán chạy nhất
	public List<ProductModel> getTop4BestSeller() {
		// Khai báo List để lưu danh sách SP
		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn
		String sql = "select TOP 4 * \r\n" + "from Product\r\n" + "order by Amount DESC";
		try {
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	// Hiển thị 1 sản phẩm bán chạy nhất và mới nhất
	public List<ProductModel> getTop1BestSellerAndNew() {
		// Khai báo List để lưu danh sách SP
		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn
		String sql = "select TOP 1 * from Product \r\n" + "order by Amount DESC, ProductID DESC";
		try {
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while (rs.next()) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {
		}
		return list;
	}
	
	// Hiện thị 1 sản phẩm mới nhất
	public ProductModel getLastProduct() {
		// Khai báo List để lưu danh sách SP
		ProductModel product = null;

		// Khai báo chuỗi truy vấn
		String sql = "select TOP 1 * from Product \r\n" + "order by ProductID DESC";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
		}
		return product;
	}

	// Hiển thị tất cả sản phẩm mới nhất
	public List<ProductModel> getAllProduct() 
	{
		// Khai báo List để lưu danh sách SP
		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn
		String sql = "select * \r\n" + "from Product \r\n" + "order by ProductID DESC";
		try 
		{
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while (rs.next()) 
			{
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} 
		catch (Exception e) {}

		return list;
	}
	
	// Hiển thị tất cả sản phẩm theo category
	public List<ProductModel> getAllProductByCategory(String categoryID) 
	{
		// Khai báo List để lưu danh sách SP
		List<ProductModel> list = new ArrayList<ProductModel>();

		// Khai báo chuỗi truy vấn
		String sql = "select * from Product\r\n"
				+ "where CategoryID = ?";
		try 
		{
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// gán giá trị cho dấu hỏi
			ps.setString(1, categoryID);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while (rs.next()) 
			{
				list.add(new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} 
		catch (Exception e) {}

		return list;
	}
	
	// lấy sản phẩm theo productID
	public ProductModel getProductByID(String productID) {
		// Khai báo List để lưu danh sách SP
		ProductModel product = null;

		// Khai báo chuỗi truy vấn
		String sql = "select * from Product\r\n"
				+ "where ProductID = ?";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			// gán giá trị cho dấu hỏi
			ps.setString(1, productID);
			rs = ps.executeQuery();

			while (rs.next()) {
				product = new ProductModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
		}
		return product;
	}
}
