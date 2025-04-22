package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Transactional
    @Override
    public void setUser(Car car, User user) {
        Long userId1 = user.getId();
        Session session = sessionFactory.getCurrentSession();
        // Ищем пользователя по ID
        User existingUser = session.get(User.class, userId1);
        if (existingUser != null) {
            car.setUser(existingUser);  // Привязываем пользователя к машине
            car.setId(userId1);          // Устанавливаем ID машины как ID пользователя
            session.save(car);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }
}