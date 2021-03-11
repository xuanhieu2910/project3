package xuanhieu.project3.service;
import xuanhieu.project3.entity.Inventory;
import java.util.List;

public interface InventoryService {
    List<Inventory> findAllInventory();

    Inventory saveInventory(Inventory inventory);

    Inventory findInventoryById(Integer id);

    String deleteInventoryById(Integer id);

    Inventory updateInventory(Inventory inventory);


    List<Inventory> findInventoryByIdProductWithBranch(Integer idProduct,Integer idBranch);

    List<Inventory>findInventoryByIdProduct(Integer idProduct);
}
