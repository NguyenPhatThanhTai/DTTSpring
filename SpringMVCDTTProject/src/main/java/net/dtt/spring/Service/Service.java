package net.dtt.spring.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.DataAccess.DataAccess;
import net.dtt.spring.DataAccess.IDataAccess;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;

@org.springframework.stereotype.Service
public class Service implements IService {
	@Autowired
	private IDataAccess _dataAccess;
	
	@Override
	public List<ProductDaoModel> GetBestSellerProduct(int amount) {
		System.out.println("ok ben service all product");
		return _dataAccess.GetProductByNumber(1, amount, null);
	}
	
	@Override
	public List<ProductDaoModel> GetRecommentProduct(int amount) {
		System.out.println("ok ben service all product");
		return _dataAccess.GetProductByNumber(1, amount, null);
	}

	@Override
	public List<CategoryDaoModel> getAllCategory() {
		System.out.println("ok ben service all category");
		return _dataAccess.GetAllCategory();
	}

	@Override
	public ProductDaoModel GetDetailproduct(int productId) {
		return _dataAccess.GetDetailProduct(productId);
	}

	@Override
	public List<ProductDaoModel> GetAllProduct(int offset, String[] cateId) {
		return _dataAccess.GetProductByNumber(offset, 10, cateId);
	}

	@Override
	public int CountProduct() {
		return _dataAccess.CountProduct();
	}
}
