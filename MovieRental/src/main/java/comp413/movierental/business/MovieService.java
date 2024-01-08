/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp413.movierental.business;

import comp413.movierental.beans.Movie;
import comp413.movierental.dao.MovieDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class MovieService {

    @Inject
    private MovieDAO movieDAO;

    public List<Movie> getAllMovies() {
        return movieDAO.listAll();
    }

    public Movie getMovieById(int id) {
        return movieDAO.get(id);
    }

    public void addMovie(Movie movie) {
        movieDAO.add(movie);
    }

    public void updateMovie(Movie movie) {
        movieDAO.update(movie);
    }

    public void deleteMovie(int id) {
        movieDAO.delete(id);
    }

    public List<Movie> searchMovies(String query) {
        return movieDAO.searchByTitle(query);
    }
}

