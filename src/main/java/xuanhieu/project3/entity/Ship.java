package xuanhieu.project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    private Integer idShip;
    @Column(name = "name_ship",length = 255,nullable = false)
    private String nameShip;
    @Column(name = "time_ship",nullable = false,length = 255)
    private String timeShip;
    @Column(name = "enable",nullable = false)
    private Integer enable;

    @OneToOne(
            mappedBy = "ship",
//            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Orders orders;

    public Ship() {
    }

    public Ship(Integer idShip, String nameShip, String timeShip, Integer enable) {
        this.idShip = idShip;
        this.nameShip = nameShip;
        this.timeShip = timeShip;
        this.enable = enable;
    }

    public Integer getIdShip() {
        return idShip;
    }

    public void setIdShip(Integer idShip) {
        this.idShip = idShip;
    }

    public String getNameShip() {
        return nameShip;
    }

    public void setNameShip(String nameShip) {
        this.nameShip = nameShip;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
//
//    public Orders getOrders() {
//        return orders;
//    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
