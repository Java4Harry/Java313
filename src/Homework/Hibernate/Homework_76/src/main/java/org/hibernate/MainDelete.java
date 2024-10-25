package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Good;
import org.hibernate.entity.Sklad;

public class MainDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Good.class).addAnnotatedClass(Sklad.class).buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Good good = session.get(Good.class, 4);
            session.remove(good);
            session.getTransaction().commit();

        } finally {

            factory.close();
        }
    }
}
