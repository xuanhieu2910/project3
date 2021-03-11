package xuanhieu.project3.entity;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetails;
    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products productsDetails;


    public OrderDetails() {
    }

    public OrderDetails(Integer idOrderDetails, Integer quantity) {
        this.idOrderDetails = idOrderDetails;
        this.quantity = quantity;
    }

    public Integer getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(Integer idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProductsDetails() {
        return productsDetails;
    }

    public void setProductsDetails(Products productsDetails) {
        this.productsDetails = productsDetails;
    }

//    public Orders getOrders() {
//        return orders;
//    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
