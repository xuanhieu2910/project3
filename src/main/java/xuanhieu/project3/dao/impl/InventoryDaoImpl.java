package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.InventoryDao;
import xuanhieu.project3.entity.Inventory;
import xuanhieu.project3.repository.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class InventoryDaoImpl implements InventoryDao {



    @Autowired
    InventoryRepository inventoryRepository;


    @Override
    public List<Inventory> findAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory findInventoryById(Integer id) {
        Optional<Inventory>inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            return inventory.get();
        }
        return null;
    }

    @Override
    public String deleteInventoryById(Integer id) {
        Optional<Inventory>inventory = inventoryRepository.findById(id);
        if(inventory.isPresent()){
            inventoryRepository.deleteById(id);
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> findInventoryByIdProductWithBranch(Integer idProduct, Integer idBranch) {
        return null;
    }

    @Override
    public List<Inventory> findIdInventoryByIdProduct(Integer idProduct) {
            return inventoryRepository.findInventoriesByIdProduct(idProduct);
    }
}
