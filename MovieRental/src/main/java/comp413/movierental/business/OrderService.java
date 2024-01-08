package comp413.movierental.business;

import comp413.movierental.beans.Order;
import comp413.movierental.dao.OrderDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class OrderService {

    @Inject
    private OrderDAO orderDAO;

    public List<Order> getAllOrders() {
        return orderDAO.listAll();
    }

    public Order getOrderById(int id) {
        return orderDAO.get(id);
    }

    public void addOrder(Order order) {
        orderDAO.add(order);
    }

    public void updateOrder(Order order) {
        orderDAO.update(order);
    }

    public void deleteOrder(int id) {
        orderDAO.delete(id);
    }
    
    public List<Order> getOrdersByUserId(int userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    
}
