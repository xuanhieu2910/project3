package xuanhieu.project3.entity;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private Integer idCustomer;
    @Column
    private String nameCustomer;
    @Column
    private String phoneCustomer;
    @Column
    private String addressCustomer;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Orders>orders = new ArrayList<>();


    public Customer() {
    }

    public Customer(Integer idCustomer, String nameCustomer, String phoneCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.phoneCustomer = phoneCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }


    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
