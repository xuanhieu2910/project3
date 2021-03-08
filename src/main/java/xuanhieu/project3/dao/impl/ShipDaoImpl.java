package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.ShipDao;
import xuanhieu.project3.entity.Ship;
import xuanhieu.project3.repository.ShipRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShipDaoImpl implements ShipDao {
    @Autowired
    ShipRepository shipRepository;
    @Override
    public List<Ship> findAllShip() {
        return shipRepository.findAll();
    }

    @Override
    public Ship findShipById(Integer id) {
        Optional<Ship>ship = shipRepository.findById(id);
        if(ship.isPresent()){
            return ship.get();
        }
        return null;
    }

    @Override
    public Ship saveShip(Ship ship) {
        return shipRepository.save(ship);
    }

    @Override
    public String deleteShipById(Integer id) {
        Optional<Ship>ship = shipRepository.findById(id);
        if(ship.isPresent()){
            shipRepository.deleteById(id);
            return "Xóa thành công!";
        }
        return null;
    }
}
