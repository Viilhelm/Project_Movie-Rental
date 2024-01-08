/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comp413.movierental.controllers;

import comp413.movierental.beans.Movie;
import comp413.movierental.business.MovieService;
import comp413.movierental.beans.ShoppingCart;
import comp413.movierental.beans.User;
import comp413.movierental.business.ShoppingCartService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/addToCart"})
public class ShoppingCartServlet extends HttpServlet {

    @EJB
    private ShoppingCartService shoppingCartService;
    @EJB
    private MovieService movieService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            int movieId = Integer.parseInt(request.getParameter("id"));
            Movie movie = movieService.getMovieById(movieId); // 使用 MovieService 来获取电影详情。
            if (movie != null) {
                // 检查购物车中是否已经有该电影
                ShoppingCart existingEntry = shoppingCartService.getShoppingCartByUserAndMovie(user.getId(), movie.getId());
                if (existingEntry == null) {
                    // 如果购物车中没有该电影，则添加
                    ShoppingCart cartEntry = new ShoppingCart(user, movie, 1); // 假设数量为 1。
                    shoppingCartService.addShoppingCartEntry(cartEntry);
                    response.sendRedirect(request.getContextPath() + "/cart"); // 重定向到购物车页面。
                } else {
                    // 如果电影已在购物车中，设置会话级别的错误消息
                    session.setAttribute("errorMessage", "Movie already in cart");
                    response.sendRedirect(request.getHeader("Referer")); // 重定向回之前的页面
                }
            } else {
                // 电影未找到，设置错误消息
                session.setAttribute("errorMessage", "Movie not found");
                response.sendRedirect(request.getHeader("Referer")); // 重定向回之前的页面
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login"); // 重定向到登录页面。
        }
    }


}
