package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    @Override
    public void deleteUser(Long id) {

        entityManager.createQuery("DELETE FROM User u WHERE u.id = :id").setParameter("id",id).executeUpdate();
    }
    @Transactional
    @Override
    public void addUser(User user) {

        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void editUser(String name,String lastName, int age,Long id) {
        entityManager.createQuery("UPDATE User u  SET u.name = :name," +
                        "u.age =:age,u.lastName =:lastName WHERE u.id =:id")
                .setParameter("name",name)
                .setParameter("age",age)
                .setParameter("lastName",lastName)
                .setParameter("id",id)
                .executeUpdate();
    }
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Transactional
    @Override
    public void addUser(String name,String lastName, int age) {
        User user = new User(name,lastName,age);
        entityManager.persist(user);
        // entityManager.flush();
    }

}

