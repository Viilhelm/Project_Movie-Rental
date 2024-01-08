package comp413.movierental.dao;

import comp413.movierental.beans.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.persistence.NoResultException;


public class UserDAO {

    @PersistenceContext(unitName = "comp413_MovieRental_war_1.0-MYSQL")
    private EntityManager em;

    @Transactional
    public void add(User user) {
        em.persist(user);
    }

    public User get(Integer id) {
        return em.find(User.class, id);
    }

    public List<User> listAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    public void update(User user) {
        em.merge(user);
    }

    @Transactional
    public void delete(Integer id) {
        User user = get(id);
        if (user != null) {
            em.remove(user);
        }
    }
    
    // 在 UserDAO 类中
    public User findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                     .setParameter("username", username)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    
    // Add more methods as needed for your application
}
