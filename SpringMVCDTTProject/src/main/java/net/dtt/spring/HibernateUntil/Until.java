package net.dtt.spring.HibernateUntil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Until {
    public static Session getSession(){
        SessionFactory sf;
        sf = new Configuration().configure("../../../../../webapp/WEB-INF/dao-cfg.xml").buildSessionFactory();
        Session s;
        s = sf.openSession();
        return s;
    }
}
