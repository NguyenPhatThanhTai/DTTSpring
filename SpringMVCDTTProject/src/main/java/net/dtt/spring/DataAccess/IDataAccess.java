package net.dtt.spring.DataAccess;


import java.util.Date;
import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
import net.dtt.spring.Models.DAOModel.OrdersDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;

public interface IDataAccess {
	public List<CategoryDaoModel> GetAllCategory();
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount, String[] cateId);
	public ProductDaoModel GetDetailProduct(int productId);
	public int CountProduct();
	public List<CommentProductDaoModel> GetCommentOfProduct(int productId);
	public boolean addComment(int id, String content, Date date, int star, int prodId, int cusId);
	public CustomerDaoModel getUserOfEmail(String Email);
	public boolean AddUser(int id, String name, int gender, Date birthday, String email, String token, String phone, String address);
	public CustomerDaoModel GetUserOfId(int userId);
}
