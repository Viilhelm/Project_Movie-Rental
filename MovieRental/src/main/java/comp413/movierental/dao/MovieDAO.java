/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp413.movierental.dao;

import comp413.movierental.beans.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class MovieDAO {
    
    @PersistenceContext(unitName = "comp413_MovieRental_war_1.0-MYSQL")
    private EntityManager entityManager;
    
    public List<Movie> listAll() {
        return entityManager.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public Movie get(int id) {
        return entityManager.find(Movie.class, id);
    }

    public void add(Movie movie) {
        entityManager.persist(movie);
    }

    public void update(Movie movie) {
        entityManager.merge(movie);
    }

    public void delete(int id) {
        Movie movie = entityManager.find(Movie.class, id);
        if (movie != null) {
            entityManager.remove(movie);
        }
    }
    
    public List<Movie> searchByTitle(String query) {
        String jpql = "SELECT m FROM Movie m WHERE LOWER(m.title) LIKE :query";
        return entityManager.createQuery(jpql, Movie.class)
                .setParameter("query", "%" + query.toLowerCase() + "%")
                .getResultList();
    }
}

