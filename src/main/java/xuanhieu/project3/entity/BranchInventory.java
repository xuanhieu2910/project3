package xuanhieu.project3.entity;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "branch_inventory")
public class BranchInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBranchInventory;

    @Column(name = "name_branch",nullable = false,length = 255)
    private String nameBranchInventory;

    @Column(name = "address_branch",nullable = false,length = 255)
    private String addressBranchInventory;

    @OneToMany(
            mappedBy = "branchInventory",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Inventory>inventories = new ArrayList<>();


    @OneToOne(
            mappedBy = "branchInventory",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private ImportInventory importInventory;


    public BranchInventory() {
    }

    public BranchInventory( String nameBranchInventory, String addressBranchInventory) {
        this.idBranchInventory = idBranchInventory;
        this.nameBranchInventory = nameBranchInventory;
        this.addressBranchInventory = addressBranchInventory;
    }

    public Integer getIdBranchInventory() {
        return idBranchInventory;
    }

    public String getNameBranchInventory() {
        return nameBranchInventory;
    }

    public void setNameBranchInventory(String nameBranchInventory) {
        this.nameBranchInventory = nameBranchInventory;
    }

    public String getAddressBranchInventory() {
        return addressBranchInventory;
    }

    public void setAddressBranchInventory(String addressBranchInventory) {
        this.addressBranchInventory = addressBranchInventory;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public void setImportInventory(ImportInventory importInventory) {
        this.importInventory = importInventory;
    }
}
