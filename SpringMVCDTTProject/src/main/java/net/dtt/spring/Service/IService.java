package net.dtt.spring.Service;

import java.util.List;

import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;

public interface IService {
	public List<ProductDaoModel> GetAllProduct();
	public List<CategoryDaoModel> getAllCategory();
}
