package xuanhieu.project3.service;
import xuanhieu.project3.entity.ImportInventory;
import xuanhieu.project3.entity.Products;
import java.util.List;

public interface ImportInventoryService {
    List<ImportInventory> findAllImportInventory();

    ImportInventory saveProductImportInventory(ImportInventory importInventory);

    ImportInventory findImportInventoryById(Integer id);

    ImportInventory updateImportInventory(ImportInventory importInventory);

    String deleteImportInventoryById(Integer id);


    ImportInventory importNewProductIntoImportInventory(Products products);
}
