package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional
public class CarDaoImpl implements CarDao{

    //private final LocalContainerEntityManagerFactoryBean entityManager;

    private EntityManager entityManager;
    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Car> listCar() {
//        TypedQuery<Car> query = entityManager.
//        return query.getResultList();
//    }

//    @Override
//
//    public List<Car> limitListCar(Long limit) {
//        String sql = "SELECT * FROM CAR LIMIT :limit";
//        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
//        query.addEntity(Car.class);
//        query.setParameter("limit",limit);
//        return (List<Car>) query.getResultList();
//
//    }
}
