package ru.kuper.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.kuper.models.Auto;
import ru.kuper.models.User;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Создаем конфигурацию Hibernate
                Configuration configuration = new Configuration().configure();
                //Передаем классы, которые он должен воспринимать как сущности
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение! " + e);
            }
        }
        return sessionFactory;
    }


}
