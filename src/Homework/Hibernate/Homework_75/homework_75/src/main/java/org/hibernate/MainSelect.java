package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Good;

import java.util.List;

public class MainSelect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Good.class).buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Good> goods = session.createQuery("from Good").list();
            for(Good good : goods){
                System.out.println(good);
            }
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
