package comp413.movierental.dao;

import comp413.movierental.beans.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class OrderDAO {
    
    @PersistenceContext(unitName = "comp413_MovieRental_war_1.0-MYSQL")
    private EntityManager entityManager;
    
    public List<Order> listAll() {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findAll", Order.class);
        return query.getResultList();
    }

    public Order get(int id) {
        TypedQuery<Order> query = entityManager.createNamedQuery("Order.findById", Order.class);
        query.setParameter("orderId", id);
        return query.getSingleResult();
    }

    public void add(Order order) {
        entityManager.persist(order);
    }

    public void update(Order order) {
        entityManager.merge(order);
    }

    public void delete(int id) {
        Order order = get(id);
        if (order != null) {
            entityManager.remove(order);
        }
    }
    
    public List<Order> getOrdersByUserId(int userId) {
        TypedQuery<Order> query = entityManager.createQuery(
            "SELECT o FROM Order o WHERE o.user.id = :userId", Order.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    
}
