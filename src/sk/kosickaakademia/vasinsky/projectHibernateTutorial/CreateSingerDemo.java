package sk.kosickaakademia.vasinsky.projectHibernateTutorial;


import Entities.Singer;
import Entities.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSingerDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Singer.class)
                .addAnnotatedClass(Song.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Singer singer = new Singer("Robo", "Grigorov");

            session.beginTransaction();
            session.save(singer);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}