package comp413.movierental.dao;

import comp413.movierental.beans.ShoppingCart;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class ShoppingCartDAO {

    @PersistenceContext(unitName = "comp413_MovieRental_war_1.0-MYSQL")
    private EntityManager entityManager;
    
    public List<ShoppingCart> listAll() {
        return entityManager.createQuery("SELECT s FROM ShoppingCart s", ShoppingCart.class).getResultList();
    }

    public ShoppingCart get(int cartId) {
        return entityManager.find(ShoppingCart.class, cartId);
    }

    public void add(ShoppingCart shoppingCart) {
        entityManager.persist(shoppingCart);
    }

    public void update(ShoppingCart shoppingCart) {
        entityManager.merge(shoppingCart);
    }

    public void delete(int cartId) {
        ShoppingCart shoppingCart = entityManager.find(ShoppingCart.class, cartId);
        if (shoppingCart != null) {
            entityManager.remove(shoppingCart);
        }
    }
    
    public List<ShoppingCart> findByUserId(int userId) {
        String jpql = "SELECT s FROM ShoppingCart s WHERE s.user.id = :userId";
        return entityManager.createQuery(jpql, ShoppingCart.class)
                .setParameter("userId", userId)
                .getResultList();
    }
    
    public List<ShoppingCart> findByMovieId(int movieId) {
        String jpql = "SELECT s FROM ShoppingCart s WHERE s.movie.id = :movieId";
        return entityManager.createQuery(jpql, ShoppingCart.class)
                .setParameter("movieId", movieId)
                .getResultList();
    }
    
    
    public ShoppingCart findByUserAndMovie(int userId, int movieId) {
        String jpql = "SELECT s FROM ShoppingCart s WHERE s.user.id = :userId AND s.movie.id = :movieId";
        List<ShoppingCart> results = entityManager.createQuery(jpql, ShoppingCart.class)
                .setParameter("userId", userId)
                .setParameter("movieId", movieId)
                .getResultList();
        return results.isEmpty() ? null : results.get(0); 
    }
}
