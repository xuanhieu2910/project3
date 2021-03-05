package xuanhieu.project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "edit_time_product")
public class EditTimeProduct {

    @Id
    private Integer idEdit;
    @Column(name = "date_edit",nullable = false)
    private String dateEdit;
    @Column(name = "status",nullable = false)
    private String status;

    @OneToOne
    @JoinColumn(name = "id_product")
    private Products products_time;

    public EditTimeProduct() {
    }

    public EditTimeProduct(Integer idEdit, String dateEdit, String status) {
        this.idEdit = idEdit;
        this.dateEdit = dateEdit;
        this.status = status;
    }

    public Integer getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(Integer idEdit) {
        this.idEdit = idEdit;
    }

    public String getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(String dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProducts_time() {
        return products_time;
    }

    public void setProducts_time(Products products_time) {
        this.products_time = products_time;
    }
}
