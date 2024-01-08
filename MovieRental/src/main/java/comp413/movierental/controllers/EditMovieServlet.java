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

@WebServlet(name = "EditMovieServlet", urlPatterns = {"/editMovie"})
public class EditMovieServlet extends HttpServlet {

    @EJB
    private MovieService movieService;

    // 显示编辑电影的表单
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = movieService.getMovieById(id);
        request.setAttribute("movie", movie);
        request.getRequestDispatcher("/WEB-INF/edit-movie.jsp").forward(request, response);
    }

    // 处理表单提交
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int movieYear = Integer.parseInt(request.getParameter("movieYear"));
        String genre = request.getParameter("genre");
        String leadingActor = request.getParameter("leadingActor");
        String studio = request.getParameter("studio");
        String director = request.getParameter("director");
        double length = Double.parseDouble(request.getParameter("length"));
        double rentalPrice = Double.parseDouble(request.getParameter("rentalPrice"));
        double costProduction = Double.parseDouble(request.getParameter("costProduction"));
        double estimatedBoxOfficeRevenue = Double.parseDouble(request.getParameter("estimatedBoxOfficeRevenue"));
        // 更新电影信息
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            movie.setTitle(title);
            movie.setMovieyear(movieYear); 
            movie.setGenre(genre);
            movie.setLeadingactor(leadingActor); 
            movie.setStudio(studio);
            movie.setDirector(director);
            movie.setLength(length);
            movie.setRentalprice(rentalPrice); 
            movie.setCostproduction(costProduction); 
            movie.setEstimatedboxofficerevenue(estimatedBoxOfficeRevenue); 
            movieService.updateMovie(movie);
        }

        // 重定向
        response.sendRedirect(request.getContextPath() + "/movieList");
    }
}
