package net.dtt.spring.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.DataAccess.DataAccess;
import net.dtt.spring.DataAccess.IDataAccess;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;

@org.springframework.stereotype.Service
public class Service implements IService {
	@Autowired
	private IDataAccess _dataAccess;
	
	@Override
	public List<ProductDaoModel> GetAllProduct() {
		return _dataAccess.GetAllProduct();
	}

	@Override
	public List<CategoryDaoModel> getAllCategory() {
		System.out.println("ok ben service");
		return _dataAccess.GetAllCategory();
	}
}
