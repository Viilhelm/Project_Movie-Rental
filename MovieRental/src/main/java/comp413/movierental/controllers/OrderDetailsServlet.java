package comp413.movierental.controllers;

import comp413.movierental.beans.Order;
import comp413.movierental.beans.OrderDetail;
import comp413.movierental.business.OrderService;
import comp413.movierental.business.OrderDetailService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {

    @EJB
    private OrderService orderService;
    @EJB
    private OrderDetailService orderDetailService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); 
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return; 
        }

        String orderIdParam = request.getParameter("orderId");
        if (orderIdParam != null) {
            try {
                int orderId = Integer.parseInt(orderIdParam);
                Order order = orderService.getOrderById(orderId);
                if (order == null) {
                    session.setAttribute("errorMessage", "Order not found");
                    response.sendRedirect(request.getHeader("Referer"));
                    return;
                }
                
                List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(orderId);
                request.setAttribute("order", order);
                request.setAttribute("orderDetails", orderDetails);
                request.getRequestDispatcher("/WEB-INF/order-details.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                session.setAttribute("errorMessage", "Invalid order ID");
                response.sendRedirect(request.getHeader("Referer"));
            }
        } else {
            session.setAttribute("errorMessage", "Order ID is required");
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
