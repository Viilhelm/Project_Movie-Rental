package comp413.movierental.controllers;

import comp413.movierental.beans.Order;
import comp413.movierental.beans.OrderDetail;
import comp413.movierental.beans.ShoppingCart;
import comp413.movierental.beans.User;
import comp413.movierental.business.OrderService;
import comp413.movierental.business.OrderDetailService;
import comp413.movierental.business.ShoppingCartService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Date;

@WebServlet("/confirmOrder")
public class ConfirmOrderServlet extends HttpServlet {

    @EJB
    private ShoppingCartService shoppingCartService;
    @EJB
    private OrderService orderService;
    @EJB
    private OrderDetailService orderDetailService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                List<ShoppingCart> cartEntries = shoppingCartService.getShoppingCartEntriesByUser(user.getId());
                
                if (!cartEntries.isEmpty()) {
                    // 创建新订单
                    Order order = createOrder(user, cartEntries);
                    orderService.addOrder(order);

                    // 创建订单详情，并清空购物车
                    for (ShoppingCart cartEntry : cartEntries) {
                        OrderDetail orderDetail = createOrderDetail(order, cartEntry);
                        orderDetailService.addOrderDetail(orderDetail);
                        shoppingCartService.deleteShoppingCartEntry(cartEntry.getCartId());
                    }

                    // 将订单ID添加到会话属性
                    request.getSession().setAttribute("orderId", order.getOrderId());

                    // 重定向到订单详情页面
                    response.sendRedirect(request.getContextPath() + "/orderDetails?orderId=" + order.getOrderId());
                } else {
                    // 处理空购物车的情况
                    response.sendRedirect(request.getContextPath() + "/cart");
                }
            } else {
                // 处理用户未登录的情况
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } catch (Exception e) {
            throw new ServletException("Error while confirming order", e);
        }
    }

    private Order createOrder(User user, List<ShoppingCart> cartEntries) {
        // 创建新订单对象
        Order order = new Order();
        // 设置订单属于的用户
        order.setUser(user);
        // 计算总价格
        double total = cartEntries.stream()
                                  .mapToDouble(entry -> entry.getQuantity() * entry.getMovie().getRentalprice())
                                  .sum();
        order.setTotal(total);
        order.setStatus("Pending");
        order.setOrderDate(new Date());

        return order;
    }


    private OrderDetail createOrderDetail(Order order, ShoppingCart cartEntry) {
        // 创建新订单详情对象
        OrderDetail orderDetail = new OrderDetail();
        // 设置订单详情关联的订单
        orderDetail.setOrder(order);
        // 设置订单详情的电影
        orderDetail.setMovie(cartEntry.getMovie());
        // 设置数量
        orderDetail.setQuantity(cartEntry.getQuantity());
        // 设置价格，通常是单个电影的租赁价格乘以数量
        orderDetail.setPrice(cartEntry.getQuantity() * cartEntry.getMovie().getRentalprice());

        return orderDetail;
    }

}
