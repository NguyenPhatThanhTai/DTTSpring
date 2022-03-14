package net.dtt.spring.DataAccess;

import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;

public interface IDataAccess {
	public List<CategoryDaoModel> GetAllCategory();
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount);
	public ProductDaoModel GetDetailProduct(int productId);
	public int CountProduct();
}
