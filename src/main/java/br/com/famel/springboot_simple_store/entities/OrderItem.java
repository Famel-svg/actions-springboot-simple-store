package br.com.famel.springboot_simple_store.entities;
import br.com.famel.springboot_simple_store.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private int quantity;
    private double Price;
    public OrderItem() {}
    public OrderItem(Order order, Product product, int quantity, double price) {
        id.setOrder(order); id.setProduct(product); this.quantity = quantity; this.Price = price;
    }
    @JsonIgnore public Order getOrder() { return id.getOrder(); }
    public void setOrder(Order order) { id.setOrder(order); }
    @JsonIgnore public Product getProduct() { return id.getProduct(); }
    public void setProduct(Product product) { id.setProduct(product); }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return Price; }
    public void setPrice(double price) { Price = price; }
    public double getSubTotal() { return Price * quantity; }
    @Override public boolean equals(Object o) { if (o == null || getClass() != o.getClass()) return false; return Objects.equals(id, ((OrderItem) o).id); }
    @Override public int hashCode() { return Objects.hashCode(id); }
}
