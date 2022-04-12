package net.dtt.spring.DataAccess;


import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import net.dtt.spring.Models.DAOModel.AdminDaoModel;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
import net.dtt.spring.Models.DAOModel.ManufacturersDaoModel;
import net.dtt.spring.Models.DAOModel.OrdersDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;

public interface IDataAccess {
	public List<CategoryDaoModel> GetAllCategory();
	public boolean AddCategory(int Id, String Name);
	public boolean DeleteCategory(int Id);
	public boolean UpdateCategory(int Id, String Name);
	public CategoryDaoModel getDetailCategory(int id);
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount, String[] cateId);
	public ProductDaoModel GetDetailProduct(int productId);
	public int CountProduct();
	public List<CommentProductDaoModel> GetCommentOfProduct(int productId);
	public boolean addComment(int id, String content, Date date, int star, int prodId, int cusId);
	public CustomerDaoModel getUserOfEmail(String Email);
	public boolean AddUser(int id, String name, int gender, Date birthday, String email, String token, String phone, String address);
	public CustomerDaoModel GetUserOfId(int userId);
	public AdminDaoModel GetUserAdmin(String Email);
	public List<ManufacturersDaoModel> getAllManufacturers();
	public boolean AddManufactor(int Id, String Name);
	public boolean DeleteManufactor(int Id);
	public boolean UpdateManufactor(int Id, String Name);
	public ManufacturersDaoModel getDetailManufactor(int id);
	public boolean AddProduct(int productId, int manufactorId, int categoryId, int detailProductId, String productName, 
			String description, float price, String img_cover, String img_hover, String img_detail1, String img_detail2,
			String img_detail3, String img_detail4);
	public boolean UpdateProduct(int productId, int manufactorId, int categoryId, int detailProductId, String productName, 
			String description, float price, String img_cover, String img_hover, String img_detail1, String img_detail2,
			String img_detail3, String img_detail4);
	public boolean SaveCart(int OrderId, List<Integer> ProductId, List<Integer> Quantity, Date OrderDate, String Name, String Phone, String Address, String Note, int Status,
			Float TotalPrice, int CustomerId);
	public boolean UpdateProductStatus(int ProdId);
	public List<CustomerDaoModel> getAllCustomer();
	public boolean DeleteCustomer(int id);
}
