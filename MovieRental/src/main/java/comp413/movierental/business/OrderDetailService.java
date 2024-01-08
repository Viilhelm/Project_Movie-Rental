package comp413.movierental.business;

import comp413.movierental.beans.OrderDetail;
import comp413.movierental.dao.OrderDetailDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class OrderDetailService {

    @Inject
    private OrderDetailDAO orderDetailDAO;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailDAO.listAll();
    }

    public OrderDetail getOrderDetailById(int id) {
        return orderDetailDAO.get(id);
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.add(orderDetail);
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        orderDetailDAO.update(orderDetail);
    }

    public void deleteOrderDetail(int id) {
        orderDetailDAO.delete(id);
    }
    
    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailDAO.findByOrderId(orderId);
    }
    
}
