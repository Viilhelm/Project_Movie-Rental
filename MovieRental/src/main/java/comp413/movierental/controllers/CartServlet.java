package comp413.movierental.controllers;

import comp413.movierental.beans.ShoppingCart;
import comp413.movierental.beans.User;
import comp413.movierental.business.ShoppingCartService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Inject
    private ShoppingCartService shoppingCartService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            List<ShoppingCart> cartEntries = shoppingCartService.getShoppingCartEntriesByUser(user.getId());
            request.setAttribute("cartEntries", cartEntries);
            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login"); // 重定向到登录页面。
        }
    }
}
