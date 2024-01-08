package comp413.movierental.beans;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ShoppingCart")
@NamedQueries({
    @NamedQuery(name = "ShoppingCart.findAll", query = "SELECT s FROM ShoppingCart s"),
    @NamedQuery(name = "ShoppingCart.findByCartId", query = "SELECT s FROM ShoppingCart s WHERE s.cartId = :cartId"),
    @NamedQuery(name = "ShoppingCart.findByUserId", query = "SELECT s FROM ShoppingCart s WHERE s.user.id = :userId"),
    @NamedQuery(name = "ShoppingCart.findByMovieId", query = "SELECT s FROM ShoppingCart s WHERE s.movie.id = :movieId")
})
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    private Integer cartId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    private Movie movie;

    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;

    public ShoppingCart() {
    }

    public ShoppingCart(User user, Movie movie, int quantity) {
        this.user = user;
        this.movie = movie;
        this.quantity = quantity;
    }
    
    public ShoppingCart(Integer cartId, User user, Movie movie, int quantity) {
        this.cartId = cartId;
        this.user = user;
        this.movie = movie;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ShoppingCart that = (ShoppingCart) object;
        return cartId != null && cartId.equals(that.cartId);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", movie=" + movie +
                ", quantity=" + quantity +
                '}';
    }
}
