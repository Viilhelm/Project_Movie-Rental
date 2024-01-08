package comp413.movierental.controllers;

import comp413.movierental.business.ShoppingCartService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/removeFromCart"})
public class RemoveFromCartServlet extends HttpServlet {

    @EJB
    private ShoppingCartService shoppingCartService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int cartId = Integer.parseInt(request.getParameter("id"));
            // Perform the removal from the cart
            shoppingCartService.deleteShoppingCartEntry(cartId);

            // Redirect back to the shopping cart page
            response.sendRedirect(request.getContextPath() + "/cart");
        } catch (NumberFormatException e) {
            // Handle exception if the id parameter is not a valid integer
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid cart ID");
        }
    }
}
