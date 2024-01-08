/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comp413.movierental.controllers;

import comp413.movierental.business.MovieService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Waley
 */
@WebServlet("/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {
    @EJB
    private MovieService movieService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 直接调用 doPost 来处理请求
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 获取电影ID
        int movieId = Integer.parseInt(request.getParameter("id"));
        
        // 调用服务层删除电影
        movieService.deleteMovie(movieId);
        
        // 重定向回电影列表页
        response.sendRedirect(request.getContextPath() + "/movieList");
    }
}

