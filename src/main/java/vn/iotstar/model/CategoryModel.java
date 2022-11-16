package vn.iotstar.model;

public class CategoryModel {
	private int categoryID;
	private String categoryName;
	private String icons;
	
	public CategoryModel() {
		super();
	}

	public CategoryModel(int categoryID, String categoryName, String icons) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.icons = icons;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getIcons() {
		return icons;
	}

	public void setIcons(String icons) {
		this.icons = icons;
	}

	@Override
	public String toString() {
		return "CategoryModel [categoryID=" + categoryID + ", categoryName=" + categoryName + ", icons=" + icons + "]";
	}	
}
