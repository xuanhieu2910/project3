package xuanhieu.project3.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    private Integer id;
    @Column
    private String dateOrder;
    @Column
    private Integer totalQuantity;
    @Column
    private Float totalPrice;
    @Column
    private String status;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "ship_id")
    private Ship ship;


    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


    @OneToMany(
            mappedBy = "orders",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<OrderDetails>orderDetailsList = new ArrayList<>();



    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public Orders(Integer id, String dateOrder, Integer totalQuantity, Float totalPrice) {
        this.id = id;
        this.dateOrder = dateOrder;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
