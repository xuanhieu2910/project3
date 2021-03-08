package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.ImportInventoryDao;
import xuanhieu.project3.entity.ImportInventory;
import xuanhieu.project3.repository.ImportInventoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImportInventoryDaoImpl implements ImportInventoryDao {

    @Autowired
    ImportInventoryRepository importInventoryRepository;

    @Override
    public List<ImportInventory> findAllImportInventory() {
        return importInventoryRepository.findAll();
    }

    @Override
    public ImportInventory saveImportInventory(ImportInventory importInventory) {
        return importInventoryRepository.save(importInventory);
    }

    @Override
    public ImportInventory findImportInventoryById(Integer id) {
        Optional<ImportInventory> importInventory = importInventoryRepository.findById(id);
        if (importInventory.isPresent()) {
            return importInventory.get();
        } else {
            return null;
        }
    }

    @Override
    public ImportInventory updateImportInventory(ImportInventory importInventory) {
        return importInventoryRepository.save(importInventory);
    }

    @Override
    public String deleteImportInventoryById(Integer id) {
        Optional<ImportInventory> importInventory = importInventoryRepository.findById(id);
        if (importInventory.isPresent()) {
            importInventoryRepository.deleteById(id);
            return "Xóa thành công!";
        } else {
            return null;
        }
    }
}
