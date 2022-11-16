package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.connection.DBConnection;
import vn.iotstar.model.CategoryModel;

public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<CategoryModel> getAllCategory(){
	
		// Khai báo List để lưu danh sách SP
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		
		// Khai báo chuỗi truy vấn
		String sql = "select * from Category";
		
		try {
			// mở kết nối database
			conn = new DBConnection().getConnection();
			// ném câu query qua sql
			ps = conn.prepareStatement(sql);
			// chạy query và nhận kết quả
			rs = ps.executeQuery();
			// lấy từ ResultSet đổ vào List
			while(rs.next())
			{
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (Exception e) {}
		
		return list;
	}
}
