package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Project;
import org.hibernate.entity.Specialist;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Project.class).addAnnotatedClass(Specialist.class).buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            Project project1 = new Project("Управление банковской системы");
            Project project2 = new Project("Интернет-магазин");
            Project project3 = new Project("Страница-визитка в Интернет");
            Project project4 = new Project("Система учета клиентов");
            Project project5 = new Project("Библиотека");
            Specialist specialist1 = new Specialist("Алексей", "Викторов", "Java Developer");
            Specialist specialist2 = new Specialist("Константин", "Ивановский", "Web-архитектор");
            Specialist specialist3 = new Specialist("Жанна", "Арисова", "Дизайнер");
            Specialist specialist4 = new Specialist("Олег", "Говоров", "Тестировщик");
            Specialist specialist5 = new Specialist("Антон", "Москвин", "Java Developer");

            /*Закрепление за одним проектом разных сотудников*/
            project1.addSpecialistToProject(specialist1);
            project1.addSpecialistToProject(specialist2);
            project1.addSpecialistToProject(specialist5);
            project1.addSpecialistToProject(specialist4);
            session.beginTransaction();
            session.persist(project1);
            session.getTransaction().commit();

            /*Закрепление разных проектов за одним сотрудником*/
            session = factory.getCurrentSession();
            specialist3.addProjectForSpecialist(project2);
            specialist3.addProjectForSpecialist(project3);
            session.beginTransaction();
            session.persist(specialist3);
            session.getTransaction().commit();

            /*Вывод информации о сотрудниках, закрепленных за определенным проектом*/
            session = factory.getCurrentSession();
            session.beginTransaction();
            Project needProject = session.get(Project.class, 1);
            System.out.println(needProject);
            System.out.println(needProject.getSpecialists());
            session.getTransaction().commit();

            /*Вывод информации о проектах, в которых участвует сотрудник*/
            session = factory.getCurrentSession();
            session.beginTransaction();
            Specialist needSpecialist = session.get(Specialist.class, 5);
            System.out.println(needSpecialist);
            System.out.println(needSpecialist.getProjects());
            session.getTransaction().commit();

            /*Удаление проекта*/
            session = factory.getCurrentSession();
            session.beginTransaction();
            Project project = session.get(Project.class, 1);
            session.remove(project);
            session.getTransaction().commit();

            /*Удаление специалиста*/
            session = factory.getCurrentSession();
            session.beginTransaction();
            Specialist specialist = session.get(Specialist.class, 5);
            session.remove(specialist);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}
