package net.dtt.spring.DataAccess;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.HibernateUntil.Until;
import net.dtt.spring.Models.DAOModel.AdminDaoModel;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
import net.dtt.spring.Models.DAOModel.DetailOrdersDaoModel;
import net.dtt.spring.Models.DAOModel.ManufacturersDaoModel;
import net.dtt.spring.Models.DAOModel.OrdersDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDetailDaoModel;
import net.dtt.spring.entity.Test;

@Transactional
public class DataAccess implements IDataAccess {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CategoryDaoModel> GetAllCategory() {
		Session session = this.sessionFactory.getCurrentSession();

		List<CategoryDaoModel> list = session.createQuery("From CategoryDaoModel C WHERE C.status = 0").list();
		
	    return list;
	}

	@Override
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount, String[] cateId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String query = "From ProductDaoModel P WHERE P.productDetail.status = 0";
		
		if(cateId != null && cateId.length == 1) {
			query += " AND P.category.id = " + Integer.parseInt(cateId[0].replaceAll("\\s+",""));
		}
		else if(cateId != null && cateId.length > 1) {
			query += " AND P.category.id = " + Integer.parseInt(cateId[0].replaceAll("\\s+",""));
			for (String idCate : cateId) {
				query += " OR P.category.id = " + Integer.parseInt(idCate.replaceAll("\\s+",""));
			}	
		}

		List<ProductDaoModel> list = session.createQuery(query).setFirstResult(offset - 1).setMaxResults(amount).list();
	    
	    return list;
	}

	@Override
	public ProductDaoModel GetDetailProduct(int productId) {
		Session session = this.sessionFactory.getCurrentSession();

		ProductDaoModel product = (ProductDaoModel) session.createQuery("From ProductDaoModel P WHERE P.id = " + productId).getSingleResult();
		
		return product;
	}

	@Override
	public int CountProduct() {
		Session session = this.sessionFactory.getCurrentSession();

		List<ProductDaoModel> list = session.createQuery("From ProductDaoModel").list();
		
	    return list.size();
	}

	@Override
	public List<CommentProductDaoModel> GetCommentOfProduct(int productId) {
		Session session = this.sessionFactory.getCurrentSession();

		List<CommentProductDaoModel> list = session.createQuery("From CommentProductDaoModel C WHERE C.product.id = " + productId).list();
		
	    return list;
	}

	@Override
	public boolean addComment(int id, String content, Date date, int star, int prodId, int cusId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CommentProductDaoModel cmt = new CommentProductDaoModel();
			cmt.setId(id);
			cmt.setStart(star);
			cmt.setContent(content);
			cmt.setTime(date);
			cmt.setProduct(session.load(ProductDaoModel.class, prodId));
			cmt.setCustomer(session.load(CustomerDaoModel.class, 1));
			
			session.persist(cmt);
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public CustomerDaoModel getUserOfEmail(String Email) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CustomerDaoModel cus = (CustomerDaoModel) session.createQuery("FROM CustomerDaoModel C where C.email = '" + Email + "'").getSingleResult();
			return cus;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean AddUser(int id, String name, int gender, Date birthday, String email, String token,
			String phone, String address) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CustomerDaoModel cus = new CustomerDaoModel();
			cus.setAddress(address);
			cus.setBirthDay(birthday);
			cus.setEmail(email);
			cus.setGender(gender);
			cus.setId(id);
			cus.setName(name);
			cus.setPhone(phone);
			cus.setToken(token);
			
			session.persist(cus);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CustomerDaoModel GetUserOfId(int userId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			CustomerDaoModel cus = (CustomerDaoModel) session.createQuery("FROM CustomerDaoModel C where C.id = '" + userId + "'").getSingleResult();
			
			return cus;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public AdminDaoModel GetUserAdmin(String Email) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			AdminDaoModel cus = (AdminDaoModel) session.createQuery("FROM AdminDaoModel A where A.email = '" + Email + "'").getSingleResult();
			return cus;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<ManufacturersDaoModel> getAllManufacturers() {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			List<ManufacturersDaoModel> manufactors = session.createQuery("FROM ManufacturersDaoModel M WHERE M.status = 0").list();
			return manufactors;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean AddProduct(int productId, int manufactorId, int categoryId, int detailProductId, String productName,
			String description, float price, String img_cover, String img_hover, String img_detail1, String img_detail2,
			String img_detail3, String img_detail4) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ProductDaoModel product = new ProductDaoModel();
			product.setId(productId);
			product.setManufacturers(session.load(ManufacturersDaoModel.class, manufactorId));
			product.setCategory(session.load(CategoryDaoModel.class, categoryId));
			
			session.persist(product);
			
			ProductDetailDaoModel productDetail = new ProductDetailDaoModel();
			productDetail.setId(detailProductId);
			productDetail.setImg_Cover(img_cover);
			productDetail.setImg_Hover(img_hover);
			productDetail.setImg_Detail1(img_detail1);
			productDetail.setImg_Detail2(img_detail2);
			productDetail.setImg_Detail3(img_detail3);
			productDetail.setImg_Detail4(img_detail4);
			productDetail.setName(productName);
			productDetail.setPrice(price);
			productDetail.setQuantityInShop(0);
			productDetail.setDescription(description);
			productDetail.setProduct(session.load(ProductDaoModel.class, productId));
			
			session.persist(productDetail);
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean UpdateProduct(int productId, int manufactorId, int categoryId, int detailProductId,
			String productName, String description, float price, String img_cover, String img_hover, String img_detail1,
			String img_detail2, String img_detail3, String img_detail4) {
		Session session = this.sessionFactory.getCurrentSession();
		
		ProductDaoModel product = new ProductDaoModel();
		product.setId(productId);
		product.setManufacturers(session.load(ManufacturersDaoModel.class, manufactorId));
		product.setCategory(session.load(CategoryDaoModel.class, categoryId));
		
		session.update(product);
		
		ProductDetailDaoModel productDetail = new ProductDetailDaoModel();
		productDetail.setId(detailProductId);
		productDetail.setImg_Cover(img_cover);
		productDetail.setImg_Hover(img_hover);
		productDetail.setImg_Detail1(img_detail1);
		productDetail.setImg_Detail2(img_detail2);
		productDetail.setImg_Detail3(img_detail3);
		productDetail.setImg_Detail4(img_detail4);
		productDetail.setName(productName);
		productDetail.setPrice(price);
		productDetail.setQuantityInShop(0);
		productDetail.setDescription(description);
		productDetail.setProduct(session.load(ProductDaoModel.class, productId));
		
		session.update(productDetail);
		
		return false;
	}

	@Override
	public boolean SaveCart(int OrderId, List<Integer> ProductId, List<Integer> Quantity, Date OrderDate, String Name,
			String Phone, String Address, String Note, int Status, Float TotalPrice, int CustomerId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		OrdersDaoModel order = new OrdersDaoModel();
		order.setAddressReceive(Address);
		order.setCustomer(session.load(CustomerDaoModel.class, CustomerId));
		order.setId(OrderId);
		order.setNameReceive(Name);
		order.setNote(Note);
		order.setPhoneReceive(Phone);
		order.setStatus(Status);
		order.setTime(OrderDate);
		order.setTotalPrice(TotalPrice);
		
		session.persist(order);
	
		for (int i = 0; i < ProductId.size(); i++) {
			DetailOrdersDaoModel detailOrder = new DetailOrdersDaoModel();
			System.out.println("================= " + ProductId.get(i));
			detailOrder.setOrder(session.load(OrdersDaoModel.class, OrderId));
			detailOrder.setProduct(session.load(ProductDaoModel.class, ProductId.get(i)));
			detailOrder.setQuantity(Quantity.get(i));
			detailOrder.setSize("Null");
			
			session.persist(detailOrder);
		}
		
		return false;
	}

	@Override
	public boolean UpdateProductStatus(int ProdId) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ProductDetailDaoModel product = session.load(ProductDetailDaoModel.class, ProdId);
			product.setStatus(-1);
			
			session.update(product);
			
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean AddManufactor(int Id, String Name) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ManufacturersDaoModel manufactor = new ManufacturersDaoModel();
			manufactor.setId(Id);
			manufactor.setName(Name);
			
			session.persist(manufactor);
			
			return true;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	@Override
	public boolean DeleteManufactor(int Id) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ManufacturersDaoModel manufactor = session.load(ManufacturersDaoModel.class, Id);
			manufactor.setStatus(-1);
			
			session.update(manufactor);
			
			return true;
//		}catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public boolean UpdateManufactor(int Id, String Name) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ManufacturersDaoModel manufactor = session.load(ManufacturersDaoModel.class, Id);
			manufactor.setName(Name);
			
			session.update(manufactor);
			
			return true;
//		}catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public ManufacturersDaoModel getDetailManufactor(int id) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			ManufacturersDaoModel manufactor = (ManufacturersDaoModel) session.createQuery("From ManufacturersDaoModel P WHERE P.id = " + id).getSingleResult();
			
			return manufactor;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}

	@Override
	public boolean AddCategory(int Id, String Name) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CategoryDaoModel category = new CategoryDaoModel();
			category.setId(Id);
			category.setName(Name);
			
			session.persist(category);
			
			return true;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	@Override
	public boolean DeleteCategory(int Id) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CategoryDaoModel category = session.load(CategoryDaoModel.class, Id);
			category.setStatus(-1);
			
			session.update(category);
			
			return true;
//		}catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public boolean UpdateCategory(int Id, String Name) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CategoryDaoModel category = session.load(CategoryDaoModel.class, Id);
			category.setName(Name);
			
			session.update(category);
			
			return true;
//		}catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public CategoryDaoModel getDetailCategory(int id) {
//		try {
			Session session = this.sessionFactory.getCurrentSession();
			
			CategoryDaoModel category = (CategoryDaoModel) session.createQuery("From CategoryDaoModel C WHERE C.id = " + id).getSingleResult();
			
			return category;
//		}catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
	}
}









