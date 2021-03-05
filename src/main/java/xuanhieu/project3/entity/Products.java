package xuanhieu.project3.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;
@Entity
@Table(name = "products")
public class Products {

    @Id
    private Integer idProduct;
    @Column(name = "name_product", nullable = false, length = 250)
    private String nameProduct;
    @Column(name = "import_price", nullable = false)
    private Float importPrice;
    @Column(name = "wholesale_prices", nullable = false)
    private Float wholesalePrices;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "price", nullable = false)
    private Float price;
    @Column(name = "status_product",nullable = false)
    private String statusProduct;
    @Column(name = "date_import",nullable = false)
    private String dateImport;
    @Column(name = "date_delete")
    private String dateDelete;



    @OneToMany(
        mappedBy = "productsDetails",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<OrderDetails>orderDetails = new ArrayList<>();

    @OneToOne(
            mappedBy ="products",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Inventory inventory;


    @ManyToOne
    @JoinColumn(name = "id_supplier")
    private Supplier supplier;

    @OneToOne(
            mappedBy = "products",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private ImportInventory importInventory;

    @OneToOne(
            mappedBy = "products_time",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private EditTimeProduct editTimeProduct;

    public Products() {
    }

    public Products(Integer idProduct, String nameProduct,
                    Float importPrice, Float wholesalePrices,
                    Integer quantity, Float price, String statusProduct,
                    String dateImport, String dateDelete) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.importPrice = importPrice;
        this.wholesalePrices = wholesalePrices;
        this.quantity = quantity;
        this.price = price;
        this.statusProduct = statusProduct;
        this.dateImport = dateImport;
        this.dateDelete = dateDelete;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Float importPrice) {
        this.importPrice = importPrice;
    }

    public Float getWholesalePrices() {
        return wholesalePrices;
    }

    public void setWholesalePrices(Float wholesalePrices) {
        this.wholesalePrices = wholesalePrices;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(String dateDelete) {
        this.dateDelete = dateDelete;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ImportInventory getImportInventory() {
        return importInventory;
    }

    public void setImportInventory(ImportInventory importInventory) {
        this.importInventory = importInventory;
    }


    public EditTimeProduct getEditTimeProduct() {
        return editTimeProduct;
    }

    public void setEditTimeProduct(EditTimeProduct editTimeProduct) {
        this.editTimeProduct = editTimeProduct;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Products{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", importPrice=" + importPrice +
                ", wholesalePrices=" + wholesalePrices +
                ", quantity=" + quantity +
                ", price=" + price +
                ", statusProduct='" + statusProduct + '\'' +
                ", dateImport='" + dateImport + '\'' +
                ", dateDelete='" + dateDelete + '\'' +
                '}';
    }
}
