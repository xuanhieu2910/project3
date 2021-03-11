package xuanhieu.project3.dao;
import xuanhieu.project3.entity.Inventory;

import java.util.*;
public interface InventoryDao {


    List<Inventory>findAllInventory();

    Inventory saveInventory(Inventory inventory);

    Inventory findInventoryById(Integer id);

    String deleteInventoryById(Integer id);

    Inventory updateInventory(Inventory inventory);


    List<Inventory> findInventoryByIdProductWithBranch(Integer idProduct,Integer idBranch);

    List<Inventory>findIdInventoryByIdProduct(Integer idProduct);
}
