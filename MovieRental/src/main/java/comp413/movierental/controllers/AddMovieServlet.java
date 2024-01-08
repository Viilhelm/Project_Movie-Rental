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

@WebServlet(name = "AddMovieServlet", urlPatterns = {"/addMovie"})
public class AddMovieServlet extends HttpServlet {

    @EJB
    private MovieService movieService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-movie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
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

        // 创建新的电影对象
        Movie newMovie = new Movie();
        newMovie.setTitle(title);
        newMovie.setMovieyear(movieYear); 
        newMovie.setGenre(genre);
        newMovie.setLeadingactor(leadingActor); 
        newMovie.setStudio(studio);
        newMovie.setDirector(director);
        newMovie.setLength(length);
        newMovie.setRentalprice(rentalPrice);
        newMovie.setCostproduction(costProduction); 
        newMovie.setEstimatedboxofficerevenue(estimatedBoxOfficeRevenue); 

        // 保存电影到数据库，这里调用了业务服务层来处理
        movieService.addMovie(newMovie);

        // 重定向
        response.sendRedirect(request.getContextPath() + "/movieList");
    }
}
