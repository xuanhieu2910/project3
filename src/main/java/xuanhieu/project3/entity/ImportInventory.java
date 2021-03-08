package xuanhieu.project3.entity;

import org.aspectj.apache.bcel.generic.BranchHandle;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "import_inventory")
public class ImportInventory {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idImportInventory;
    @Column(name ="quantity",nullable = false)
    private Integer quantity;
    @Column(name = "price_import",nullable = false)
    private Float priceImport;
    @Column(name = "date_import",nullable = false)
    private String dateImport;
    @Column(name = "status",nullable = false)
    private String status;
    @Column(name = "enable",nullable = false)
    private Integer enable;

    @OneToOne
    @JoinColumn(name = "id_inventory")
    private BranchInventory branchInventory;

    @ManyToOne
    @JoinColumn(name = "id_products")
    private Products products;


    public ImportInventory(){}

    public ImportInventory( Integer quantity,
                           Float priceImport, String dateImport, String status, Integer enable) {
        this.quantity = quantity;
        this.priceImport = priceImport;
        this.dateImport = dateImport;
        this.status = status;
        this.enable = enable;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(Float priceImport) {
        this.priceImport = priceImport;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public BranchInventory getBranchInventory() {
        return branchInventory;
    }

    public void setBranchInventory(BranchInventory branchInventory) {
        this.branchInventory = branchInventory;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Products getProducts() {
        return products;
    }
}
