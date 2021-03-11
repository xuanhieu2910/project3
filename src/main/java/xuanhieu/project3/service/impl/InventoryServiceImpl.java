package xuanhieu.project3.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.InventoryDao;
import xuanhieu.project3.entity.Inventory;
import xuanhieu.project3.service.InventoryService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date dateCurrent;
    public static Date dateExpiry;
    public static List<Inventory>inventories;
    public static int sizeInventory;


    @Autowired
    InventoryDao inventoryDao;

    private boolean checkTimeDateExpiry(Inventory inventory){
        try {
            dateCurrent = new Date();
            String convertDate  =simpleDateFormat.format(dateCurrent);
            dateCurrent = simpleDateFormat.parse(convertDate);
            dateExpiry = simpleDateFormat.parse(inventory.getExpiryDate());
            if(dateCurrent.compareTo(dateExpiry)>0){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }




    @Override
    public List<Inventory> findAllInventory() {
        inventories = inventoryDao.findAllInventory();
        sizeInventory = inventories.size();
        for(int i=0;i<sizeInventory;i++){
            if(checkTimeDateExpiry(inventories.get(i))){
                inventories.get(i).setTotalInventory(inventories.get(i).getTotalSales());
                inventories.get(i).setTotalSales(0);
            }
        }
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
    public List<Inventory> findInventoryByIdProductWithBranch(Integer idProduct, Integer idBranch) {
        return null;
    }

    @Override
    public List<Inventory> findInventoryByIdProduct(Integer idProduct) {
                return inventoryDao.findIdInventoryByIdProduct(idProduct);
    }

}
