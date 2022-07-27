package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.Car;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional
public class CarDaoImpl implements CarDao{

    private final SessionFactory sessionFactory;

    @Autowired
    CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCar() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override

    public List<Car> limitListCar(Long limit) {
        String sql = "SELECT * FROM CAR LIMIT :limit";
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(Car.class);
        query.setParameter("limit",limit);
        return (List<Car>) query.getResultList();

    }
}
