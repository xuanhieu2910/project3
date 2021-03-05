package xuanhieu.project3.entity;


import javax.persistence.*;

@Entity
@Table(name = "import_inventory")
public class ImportInventory {

    @Id
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
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name = "id_products")
    private Products products;


    public ImportInventory(){}

    public ImportInventory(Integer idImportInventory, Integer quantity,
                           Float priceImport, String dateImport, String status, Integer enable) {
        this.idImportInventory = idImportInventory;
        this.quantity = quantity;
        this.priceImport = priceImport;
        this.dateImport = dateImport;
        this.status = status;
        this.enable = enable;
    }

    public Integer getIdImportInventory() {
        return idImportInventory;
    }

    public void setIdImportInventory(Integer idImportInventory) {
        this.idImportInventory = idImportInventory;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
