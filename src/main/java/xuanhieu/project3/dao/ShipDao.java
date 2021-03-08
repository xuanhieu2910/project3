package xuanhieu.project3.dao;

import xuanhieu.project3.entity.Ship;
import java.util.*;
public interface ShipDao {

    List<Ship>findAllShip();

    Ship findShipById(Integer id);

    Ship saveShip(Ship ship);

    String deleteShipById(Integer id);
}
