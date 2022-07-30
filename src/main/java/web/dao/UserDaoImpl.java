package web.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    //private final LocalContainerEntityManagerFactoryBean entityManager;

    private EntityManager entityManager;
    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUser() {
     Query query = entityManager.createQuery("SELECT u FROM User u");
     return query.getResultList();
         }
    }

