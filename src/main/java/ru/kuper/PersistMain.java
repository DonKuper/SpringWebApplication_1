package ru.kuper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.kuper.models.Auto;
import ru.kuper.models.User;
import ru.kuper.services.UserTransactionsService;


public class PersistMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");
//                ((AnnotationConfigApplicationContext) applicationContext).refresh();

        UserTransactionsService userTransactionsService = applicationContext.getBean(UserTransactionsService.class);


        User user = new User("Маша", 23);
        userTransactionsService.saveUser(user);
        Auto ferrari = new Auto("Ferrari","red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford","black");
        ford.setUser(user);
        user.addAuto(ford);
        userTransactionsService.updateUser(user);
        System.out.println(user.showInfo());
    }
}