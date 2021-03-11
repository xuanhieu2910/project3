package xuanhieu.project3.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.ShipDao;
import xuanhieu.project3.entity.Ship;
import xuanhieu.project3.service.ShipService;

import java.util.List;
@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipDao shipDao;

    @Override
    public List<Ship> findAllShip() {
        return shipDao.findAllShip();
    }

    @Override
    public Ship findShipById(Integer id) {
        return shipDao.findShipById(id);
    }

    @Override
    public Ship saveShip(Ship ship) {
        return shipDao.saveShip(ship);
    }

    @Override
    public String deleteShipById(Integer id) {
        if(shipDao.deleteShipById(id)!=null){
            return "Xóa thành công";
        }
        return null;
    }
}
