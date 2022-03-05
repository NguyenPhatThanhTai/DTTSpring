package net.dtt.spring.DataAccess;

import org.hibernate.SessionFactory;

public class DataAccess implements IDataAccess {
	private SessionFactory _session;

	public void setSessionFactory(SessionFactory sessionFactory) {
	    this._session = sessionFactory;
	}
}
