package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.InventoryDao;
import xuanhieu.project3.entity.Inventory;
import xuanhieu.project3.service.InventoryService;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDao inventoryDao;

    @Override
    public List<Inventory> findAllInventory() {

        return inventoryDao.findAllInventory();
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryDao.saveInventory(inventory);
    }

    @Override
    public Inventory findInventoryById(Integer id) {
        return inventoryDao.findInventoryById(id);
    }

    @Override
    public String deleteInventoryById(Integer id) {
        return inventoryDao.deleteInventoryById(id);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryDao.updateInventory(inventory);
    }

    @Override
    public List<Inventory> findInventoryByIdProduct(Integer idProduct,Integer idBranch) {
        return inventoryDao.findInventoryByIdProduct(idProduct,idBranch);
    }
}
