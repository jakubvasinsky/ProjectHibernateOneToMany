package sk.kosickaakademia.vasinsky.projectHibernateTutorial;


import Entities.Singer;
import Entities.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSongDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Singer.class)
                .addAnnotatedClass(Song.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 1;
            Singer singer = session.get(Singer.class, id);

            Song song1 = new Song("ZuvackaZaUchom");
            Song song2 = new Song("Edo");

            singer.add(song1);
            singer.add(song2);

            session.save(song1);
            session.save(song2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}