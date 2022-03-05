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
		Test test = new Test();
		test.setName(name);
		test.setNote(Note);
		test.setId(id);
		
		session.persist(test);
		
//		Two two = new Two();
//		two.setTwoId("2");
//		two.settest(session.load(Test.class, "1"));
//		two.setNote("Two2");
//		
//		session.persist(two);
		
		
		//delete
//		Two two = session.load(Two.class, "123");//select * from DataTest where id= ?
//		session.delete(two);
		
		//update
//		session.update(new Test("1", "test update", "Oke"));
	}

}
