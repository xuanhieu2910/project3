package xuanhieu.project3.service;

import xuanhieu.project3.entity.Ship;
import java.util.*;
public interface ShipService {

    List<Ship>findAllShip();

    Ship findShipById(Integer id);

    Ship saveShip(Ship ship);

    String deleteShipById(Integer id);

}
