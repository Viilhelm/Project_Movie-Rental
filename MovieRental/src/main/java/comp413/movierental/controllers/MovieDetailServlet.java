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

/**
 *
 * @author Waley
 */
@WebServlet("/movieDetail")
public class MovieDetailServlet extends HttpServlet {
    
    @EJB
    private MovieService movieService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int movieId = Integer.parseInt(idParam);
                Movie movie = movieService.getMovieById(movieId);
                if (movie != null) {
                    request.setAttribute("movie", movie);
                    request.getRequestDispatcher("/WEB-INF/movie-detail.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Movie not found");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie ID");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing movie ID");
        }
    }
}

