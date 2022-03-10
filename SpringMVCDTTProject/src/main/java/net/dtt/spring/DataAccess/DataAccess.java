package net.dtt.spring.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.HibernateUntil.Until;
import net.dtt.spring.Models.DAOModel.CategoryDaoModel;
import net.dtt.spring.Models.DAOModel.ProductDaoModel;
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
	public List<ProductDaoModel> GetProductByNumber(int amount) {
		Session session = this.sessionFactory.getCurrentSession();

		List<ProductDaoModel> list = session.createQuery("From ProductDaoModel").setMaxResults(amount).list();
	    
	    return list;
	}
}
