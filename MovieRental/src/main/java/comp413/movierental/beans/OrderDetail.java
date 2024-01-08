package comp413.movierental.beans;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "order_details")
@NamedQueries({
    @NamedQuery(name = "OrderDetail.findAll", query = "SELECT od FROM OrderDetail od"),
    @NamedQuery(name = "OrderDetail.findById", query = "SELECT od FROM OrderDetail od WHERE od.orderDetailId = :orderDetailId"),
    @NamedQuery(name="OrderDetail.findByOrder", query="SELECT od FROM OrderDetail od WHERE od.order.orderId = :orderId"),
    @NamedQuery(name="OrderDetail.findByOrderId", query="SELECT od FROM OrderDetail od WHERE od.order.orderId = :orderId"),
    @NamedQuery(name = "OrderDetail.findByMovie", query = "SELECT od FROM OrderDetail od WHERE od.movie.id = :movieId")
})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_detail_id")
    private Integer orderDetailId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private Order order;

    @JoinColumn(name = "movie_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Movie movie;
    
    public OrderDetail() {
    }

    public OrderDetail(Integer orderDetailId, Integer quantity, Double price, Order order, Movie movie) {
        this.orderDetailId = orderDetailId;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.movie = movie;
    }

    // Getters and Setters
    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // toString
    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", order=" + order +
                ", movie=" + movie +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(getOrderDetailId(), that.getOrderDetailId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderDetailId());
    }
}