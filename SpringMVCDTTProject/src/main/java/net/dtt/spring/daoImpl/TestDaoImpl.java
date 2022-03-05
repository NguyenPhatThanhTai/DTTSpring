package net.dtt.spring.daoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import net.dtt.spring.dao.TestDao;
import net.dtt.spring.entity.Test;
import net.dtt.spring.entity.Two;

@Transactional
public class TestDaoImpl implements TestDao {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	public List<Test> listTestData() {
		Session session = this.sessionFactory.getCurrentSession();

		List<Test> list = session.createQuery("From Test").list();
	    
	    return list;
	}

	public void createTestData(String id, String name, String Note) {
		Session session = this.sessionFactory.getCurrentSession();
		
		//add
//		Test test = new Test();
//		test.setName("Taei");
//		test.setNote("hello");
//		test.setId("4");
//		
//		session.persist(test);
		
		//delete
//		Two two = session.load(Two.class, "123");//select * from DataTest where id= ?
//		session.delete(two);
		
		//update
//		session.update(new Test("1", "test update", "Oke"));
	}

}
