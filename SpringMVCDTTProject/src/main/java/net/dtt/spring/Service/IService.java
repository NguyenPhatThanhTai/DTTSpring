package net.dtt.spring.Service;

import java.sql.Date;
import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
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
}
