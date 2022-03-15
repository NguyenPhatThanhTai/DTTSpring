package net.dtt.spring.DataAccess;

import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;

public interface IDataAccess {
	public List<CategoryDaoModel> GetAllCategory();
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount, String[] cateId);
	public ProductDaoModel GetDetailProduct(int productId);
	public int CountProduct();
}
