package xuanhieu.project3.entity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    private Integer idSupplier;
    @Column(name = "name_supplier", nullable = false)
    private String nameSupplier;
    @Column(name = "address_supplier", nullable = false)
    private String addressSupplier;


    @OneToMany(
            mappedBy = "supplier",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Products>productsList = new ArrayList<>();

    public Supplier(){}


    public Supplier(Integer idSupplier, String nameSupplier, String addressSupplier) {
        this.idSupplier = idSupplier;
        this.nameSupplier = nameSupplier;
        this.addressSupplier = addressSupplier;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
