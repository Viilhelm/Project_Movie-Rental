/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package comp413.movierental.controllers;

import comp413.movierental.business.MovieService;
import comp413.movierental.beans.Movie;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Waley
 */
@WebServlet("/movieList")
public class MovieListServlet extends HttpServlet {

    @EJB
    private MovieService movieService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Movie> movies = movieService.getAllMovies();
        request.setAttribute("movies", movies); // 将电影列表存储在请求属性中
        request.getRequestDispatcher("/WEB-INF/movie-list.jsp").forward(request, response); // 转发到 JSP 页面
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Movie> movies = movieService.getAllMovies();
        request.setAttribute("movies", movies); // 将电影列表存储在请求属性中
        request.getRequestDispatcher("/WEB-INF/movie-list.jsp").forward(request, response); // 转发到 JSP 页面
    }

    @Override
    public String getServletInfo() {
        return "MovieListServlet handles listing movies";
    }
}