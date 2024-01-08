package comp413.movierental.dao;

import comp413.movierental.beans.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class OrderDetailDAO {
    
    @PersistenceContext(unitName = "comp413_MovieRental_war_1.0-MYSQL")
    private EntityManager entityManager;
    
    public List<OrderDetail> listAll() {
        TypedQuery<OrderDetail> query = entityManager.createNamedQuery("OrderDetail.findAll", OrderDetail.class);
        return query.getResultList();
    }

    public OrderDetail get(int id) {
        TypedQuery<OrderDetail> query = entityManager.createNamedQuery("OrderDetail.findById", OrderDetail.class);
        query.setParameter("orderDetailId", id);
        return query.getSingleResult();
    }

    public void add(OrderDetail orderDetail) {
        entityManager.persist(orderDetail);
    }

    public void update(OrderDetail orderDetail) {
        entityManager.merge(orderDetail);
    }

    public void delete(int id) {
        OrderDetail orderDetail = get(id);
        if (orderDetail != null) {
            entityManager.remove(orderDetail);
        }
    }
    
    public List<OrderDetail> findByOrderId(int orderId) {
        TypedQuery<OrderDetail> query = entityManager.createNamedQuery("OrderDetail.findByOrderId", OrderDetail.class);
        query.setParameter("orderId", orderId);
        return query.getResultList();
    }

}
