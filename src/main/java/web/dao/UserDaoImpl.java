package web.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    //private final LocalContainerEntityManagerFactoryBean entityManager;

    private EntityManager entityManager;


    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(findById(id));
    }

    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }


    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }


}

