package net.dtt.spring.Service;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
import net.dtt.spring.Models.DAOModel.ManufacturersDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;

public interface IService {
	public List<ProductDaoModel> GetBestSellerProduct(int amount);
	public List<ProductDaoModel> GetRecommentProduct(int amount);
	public List<CategoryDaoModel> getAllCategory();
	public ProductDaoModel GetDetailproduct(int productId);
	public List<ProductDaoModel> GetAllProduct(int offset, String[] cateId);
	public int CountProduct();
	public List<CommentProductDaoModel> GetCommentOfProduct(int productId);
	public boolean sentComment(String content, int star, int prodId, int cusId);
	public boolean CheckLogin(String Email, String Password);
	public boolean AddUser(String name, int gender, Date birthday, String email, String password,
			String phone, String address);
	public CustomerDaoModel GetUserById(int userId);
	public CustomerDaoModel GetUserByEmail(String email);
	public boolean CheckLoginAdmin(String Email, String Password);
	public List<ManufacturersDaoModel> getAllManufacturers();
	public boolean AddProduct(int manufactorId, int categoryId, String productName,
			String description, float price, String img_cover, String img_hover, String img_detail1, String img_detail2,
			String img_detail3, String img_detail4);
	public boolean UpdateProduct(int productId, int manufactorId, int categoryId, int detailProductId,
			String productName, String description, float price, String img_cover, String img_hover, String img_detail1,
			String img_detail2, String img_detail3, String img_detail4);
}
