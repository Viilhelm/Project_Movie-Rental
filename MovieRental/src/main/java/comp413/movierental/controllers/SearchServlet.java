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
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @EJB
    private MovieService movieService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        if(query != null && !query.trim().isEmpty()) {
            List<Movie> searchResults = movieService.searchMovies(query);
            request.setAttribute("searchResults", searchResults);
        }
        request.getRequestDispatcher("/WEB-INF/search-results.jsp").forward(request, response);
    }
}

