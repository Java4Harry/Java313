package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Good;

public class MainAdd {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Good.class).buildSessionFactory();
        try{
            Session session = factory.getCurrentSession();
            Good good1 = new Good("Яблоко", "Россия", "Фрукты", 60);
            Good good2 = new Good("Рахат-Лукум", "Турция", "Сладости", 350);
            Good good3 = new Good("Пряники", "Россия", "Сладости", 180);
            session.beginTransaction();
            session.persist(good1);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(good2);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(good3);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}
