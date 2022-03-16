package net.dtt.spring.DataAccess;


import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.HibernateUntil.Until;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.CommentProductDaoModel;
import net.dtt.spring.Models.DAOModel.CustomerDaoModel;
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

		List<CategoryDaoModel> list = session.createQuery("From CategoryDaoModel").list();
		
	    return list;
	}

	@Override
	public List<ProductDaoModel> GetProductByNumber(int offset, int amount, String[] cateId) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String query = "From ProductDaoModel P";
		
		if(cateId != null && cateId.length == 1) {
			query += " WHERE P.category.id = " + Integer.parseInt(cateId[0].replaceAll("\\s+",""));
		}
		else if(cateId != null && cateId.length > 1) {
			query += " WHERE P.category.id = " + Integer.parseInt(cateId[0].replaceAll("\\s+",""));
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
}
