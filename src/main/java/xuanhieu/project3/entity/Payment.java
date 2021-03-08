package xuanhieu.project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    private Integer idPayment;
    @Column(name = "name_payment",nullable = false,length = 255)
    private String namePayment;
    @Column(name = "date_payment",length = 255,nullable = false)
    private String datePayment;
    @Column(name = "enable",nullable = false)
    private Integer enable;

    @OneToOne(
            mappedBy = "payment",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Orders orders;


    public Payment() {
    }

    public Payment(Integer idPayment, String namePayment, String datePayment, Integer enable) {
        this.idPayment = idPayment;
        this.namePayment = namePayment;
        this.datePayment = datePayment;
        this.enable = enable;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getNamePayment() {
        return namePayment;
    }

    public void setNamePayment(String namePayment) {
        this.namePayment = namePayment;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

//    public Orders getOrders() {
//        return orders;
//    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
