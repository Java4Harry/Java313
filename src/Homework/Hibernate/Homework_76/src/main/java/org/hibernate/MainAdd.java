package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Good;
import org.hibernate.entity.Sklad;

public class MainAdd {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Good.class).addAnnotatedClass(Sklad.class).buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            Sklad info1 = new Sklad("Самара", "ул.Рыбина,15", 1500);
            Good good1 = new Good("Яблоко", "Россия", "Фрукты",60);
            Good good12 = new Good("Рахат-Лукум", "Турция", "Сладости", 350);
            Sklad info2 = new Sklad("Склад Краснодар", "ул,Береговая,1", 6000);
            Good good2 = new Good("Пряники", "Россия", "Сладости", 180);
            Good good23 = new Good("Чипсы", "Россия", "Снэки", 120);
            Sklad info3 = new Sklad("Склад Тула", "ул.Новая, 212", 15000);
            Good good3 = new Good("Виноград", "Италия", "Фрукты", 600);
            info1.addGoodToSklad(good1);
            info1.addGoodToSklad(good12);
            info2.addGoodToSklad(good2);
            info2.addGoodToSklad(good23);
            info3.addGoodToSklad(good3);

            session.beginTransaction();
            session.persist(info1);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(info2);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(info3);
            session.getTransaction().commit();
        } finally {

            factory.close();
        }
    }
}
