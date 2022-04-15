package net.dtt.spring.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.DataAccess.DataAccess;
import net.dtt.spring.DataAccess.IDataAccess;
import net.dtt.spring.JBCrypt.JBCRYPT;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
import net.dtt.spring.Models.DAOModel.ManufacturersDaoModel;
import net.dtt.spring.Models.DAOModel.OrdersDaoModel;
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

	@Override
	public List<CommentProductDaoModel> GetCommentOfProduct(int productId) {
		return _dataAccess.GetCommentOfProduct(productId);
	}

	@Override
	public boolean sentComment(String content, int star, int prodId, int cusId) {
		try {
			Calendar calendar = Calendar.getInstance();
			int id = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
	
			Date parseDate;
			
			parseDate = dateFormat.parse(dateFormat.format(date));
			
			return _dataAccess.addComment(id, content, parseDate, star, prodId, cusId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean CheckLogin(String Email, String Password) {
		JBCRYPT jbCrypt = new JBCRYPT();
		var user = _dataAccess.getUserOfEmail(Email);
		
		if(user != null) {
			return jbCrypt.checkpw(Password, user.getToken());
		}
		return false;
	}

	@Override
	public boolean AddUser(String name, int gender, java.sql.Date birthday, String email, String password, String phone,
			String address) {
		Calendar calendar = Calendar.getInstance();
		int id = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		
		JBCRYPT jbCrypt = new JBCRYPT();
		password = jbCrypt.hashpw(password, jbCrypt.gensalt(12));
		
		return _dataAccess.AddUser(id, name, gender, birthday, email, password, phone, address);
	}

	@Override
	public CustomerDaoModel GetUserById(int userId) {
		var cusDataGet = _dataAccess.GetUserOfId(userId);
		
		cusDataGet.setToken(null);
		
		return cusDataGet;
	}

	@Override
	public CustomerDaoModel GetUserByEmail(String email) {
		return _dataAccess.getUserOfEmail(email);
	}

	@Override
	public boolean CheckLoginAdmin(String Email, String Password) {
		JBCRYPT jbCrypt = new JBCRYPT();
		var user = _dataAccess.GetUserAdmin(Email);
		
		if(user != null) {
			return jbCrypt.checkpw(Password, user.getPassword());
		}
		return false;
	}

	@Override
	public List<ManufacturersDaoModel> getAllManufacturers() {
		return _dataAccess.getAllManufacturers();
	}

	@Override
	public boolean AddProduct(int manufactorId, int categoryId, String productName, String description, float price,
			String img_cover, String img_hover, String img_detail1, String img_detail2, String img_detail3,
			String img_detail4) {
		Calendar calendar = Calendar.getInstance();
		int productId = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		int detailProductId = calendar.get(Calendar.MINUTE) + calendar.get(Calendar.MONTH) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		
		return _dataAccess.AddProduct(productId, manufactorId, categoryId, detailProductId, productName, description, price, img_cover, img_hover, img_detail1, img_detail2, img_detail3, img_detail4);
	}

	@Override
	public boolean UpdateProduct(int productId, int manufactorId, int categoryId, int detailProductId,
			String productName, String description, float price, String img_cover, String img_hover, String img_detail1,
			String img_detail2, String img_detail3, String img_detail4) {
		
		return _dataAccess.UpdateProduct(productId, manufactorId, categoryId, detailProductId, productName, description, price, 
				img_cover, img_hover, img_detail1, img_detail2, img_detail3, img_detail4);
	}

	@Override
	public boolean CheckOutCard(List<Integer> ProductId, List<Integer> Quantity,
			String Name, String Phone, String Address, String Note, int Status, Float TotalPrice, int CustomerId) {
		try {
			Calendar calendar = Calendar.getInstance();
			int id = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();

			Date parseDate;
			
			parseDate = dateFormat.parse(dateFormat.format(date));
			
			return _dataAccess.SaveCart(id, ProductId, Quantity, parseDate, Name, Phone, Address, Note, Status, TotalPrice, CustomerId);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateStatusProduct(int ProdId) {
		
		return _dataAccess.UpdateProductStatus(ProdId);
	}

	@Override
	public boolean AddManufactor(String Name) {
		Calendar calendar = Calendar.getInstance();
		int id = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		
		return _dataAccess.AddManufactor(id, Name);
	}

	@Override
	public boolean DeleteManufactor(int Id) {
		
		return _dataAccess.DeleteManufactor(Id);
	}

	@Override
	public boolean UpdateManufactor(int Id, String Name) {

		return  _dataAccess.UpdateManufactor(Id, Name);
	}

	@Override
	public ManufacturersDaoModel GetManufactor(int Id) {

		return _dataAccess.getDetailManufactor(Id);
	}

	@Override
	public boolean AddCategory(String Name) {
		Calendar calendar = Calendar.getInstance();
		int id = calendar.get(Calendar.MONTH) + calendar.get(Calendar.MINUTE) + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND);
		
		return _dataAccess.AddCategory(id, Name);
	}

	@Override
	public boolean DeleteCategory(int Id) {

		return _dataAccess.DeleteCategory(Id);
	}

	@Override
	public boolean UpdateCategory(int Id, String Name) {

		return _dataAccess.UpdateCategory(Id, Name);
	}

	@Override
	public CategoryDaoModel GetCategory(int Id) {

		return _dataAccess.getDetailCategory(Id);
	}

	@Override
	public List<CustomerDaoModel> GetCustomer() {
		return _dataAccess.getAllCustomer();
	}

	@Override
	public boolean DeleteCustomer(int id) {
		return _dataAccess.DeleteCustomer(id);
	}

	@Override
	public List<OrdersDaoModel> GetAllOrder() {
		return _dataAccess.GetAllOrder();
	}

	@Override
	public OrdersDaoModel GetOrderById(int OrderId) {
		return _dataAccess.GetOrderById(OrderId);
	}
}













