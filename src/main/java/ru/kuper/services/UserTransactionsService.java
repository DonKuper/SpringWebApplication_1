package ru.kuper.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.kuper.models.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@ApplicationScoped
@Transactional
public class UserTransactionsService {

    @PersistenceContext
    private EntityManager entityManager;

    public UserTransactionsService() {

    }

    public void createNewUser(String name, int age) {
//        User userEntity = entityManager.find(User.class,name);
        User user = new User();
        user.setName(name);
        user.setAge(age);
        entityManager.persist(user);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }


    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
