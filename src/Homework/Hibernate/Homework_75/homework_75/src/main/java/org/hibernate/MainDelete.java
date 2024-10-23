package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Good;

public class MainDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Good.class).buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Good good = session.get(Good.class, 3);
            session.remove(good);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
