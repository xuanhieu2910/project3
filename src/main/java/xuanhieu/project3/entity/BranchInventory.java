package xuanhieu.project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "branch_inventory")
public class BranchInventory {

    @Id
    private Integer idBranch;
    @Column(name = "name_branch",nullable = false,length = 255)
    private String nameBranch;
    @Column(name = "address_branch",nullable = false,length = 255)
    private String addressBranch;

    @ManyToOne
    @JoinColumn(name = "id_inventory")
    private Inventory inventory;

    public BranchInventory(Integer idBranch, String nameBranch, String addressBranch) {
        this.idBranch = idBranch;
        this.nameBranch = nameBranch;
        this.addressBranch = addressBranch;
    }

    public BranchInventory() {
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getAddressBranch() {
        return addressBranch;
    }

    public void setAddressBranch(String addressBranch) {
        this.addressBranch = addressBranch;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
