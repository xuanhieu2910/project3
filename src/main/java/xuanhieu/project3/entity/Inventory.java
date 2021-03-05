package xuanhieu.project3.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    private Integer idInventory;
    @Column(name = "name_inventory",nullable = false,length = 255)
    private String nameInventory;
    @Column(name = "total_inventory",nullable = false)
    private Integer totalInventory;
    @Column(name = "total_sales",nullable = false)
    private Integer totalSales;

    @OneToMany(
            mappedBy = "inventory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BranchInventory>branchInventoryList = new ArrayList<>();

    @OneToOne(
            mappedBy = "inventory",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private ImportInventory importInventory;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;


    public Inventory() {
    }

    public Inventory(Integer idInventory, String nameInventory, Integer totalInventory, Integer totalSales) {
        this.idInventory = idInventory;
        this.nameInventory = nameInventory;
        this.totalInventory = totalInventory;
        this.totalSales = totalSales;
    }

    public Integer getId() {
        return idInventory;
    }

    public void setId(Integer id) {
        this.idInventory = id;
    }

    public String getNameInventory() {
        return nameInventory;
    }

    public void setNameInventory(String nameInventory) {
        this.nameInventory = nameInventory;
    }

    public Integer getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(Integer totalInventory) {
        this.totalInventory = totalInventory;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    public List<BranchInventory> getBranchInventoryList() {
        return branchInventoryList;
    }

    public void setBranchInventoryList(List<BranchInventory> branchInventoryList) {
        this.branchInventoryList = branchInventoryList;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public ImportInventory getImportInventory() {
        return importInventory;
    }

    public void setImportInventory(ImportInventory importInventory) {
        this.importInventory = importInventory;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
