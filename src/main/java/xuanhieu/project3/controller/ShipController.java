package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.Ship;
import xuanhieu.project3.service.ShipService;
import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class ShipController {

    @Autowired
    ShipService shipService;


    @GetMapping(value = "/ships")
    public List<Ship> getAllShip(){
        return  shipService.findAllShip();
    }

    @PostMapping(value = "/ship")
    public Ship createShip(@RequestBody Ship ship){
        return shipService.saveShip(ship);
    }

    @GetMapping(value = "/ship/{id}")
    public Ship getShipById(@PathVariable("id")Integer id){
        if(shipService.findShipById(id)!=null){
           return  shipService.findShipById(id);
        }
        return null;
    }
}
