package comp413.movierental.business;

import comp413.movierental.beans.ShoppingCart;
import comp413.movierental.dao.ShoppingCartDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ShoppingCartService {

    @Inject
    private ShoppingCartDAO shoppingCartDAO;

    public List<ShoppingCart> getAllShoppingCartEntries() {
        return shoppingCartDAO.listAll();
    }

    public ShoppingCart getShoppingCartEntry(int cartId) {
        return shoppingCartDAO.get(cartId);
    }

    public void addShoppingCartEntry(ShoppingCart shoppingCart) {
        shoppingCartDAO.add(shoppingCart);
    }

    public void updateShoppingCartEntry(ShoppingCart shoppingCart) {
        shoppingCartDAO.update(shoppingCart);
    }

    public void deleteShoppingCartEntry(int cartId) {
        shoppingCartDAO.delete(cartId);
    }

    public List<ShoppingCart> getShoppingCartEntriesByUser(int userId) {
        return shoppingCartDAO.findByUserId(userId);
    }

    public List<ShoppingCart> getShoppingCartEntriesByMovie(int movieId) {
        return shoppingCartDAO.findByMovieId(movieId);
    }

    public ShoppingCart getShoppingCartByUserAndMovie(int userId, int movieId) {
        return shoppingCartDAO.findByUserAndMovie(userId, movieId);
    }
}
