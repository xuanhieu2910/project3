package xuanhieu.project3.dao;
import xuanhieu.project3.entity.ImportInventory;

import java.util.*;
public interface ImportInventoryDao {

    List<ImportInventory>findAllImportInventory();

    ImportInventory saveImportInventory(ImportInventory importInventory);

    ImportInventory findImportInventoryById(Integer id);

    ImportInventory updateImportInventory(ImportInventory importInventory);

    String deleteImportInventoryById(Integer id);
}
