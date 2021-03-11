package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.ImportInventory;
import xuanhieu.project3.service.ImportInventoryService;
import xuanhieu.project3.service.ProductsService;

import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class ImportInventoryController {

    @Autowired
    ImportInventoryService importInventoryService;


    @GetMapping(value = "/imports")
    public List<ImportInventory>importInventoryList(){
       return importInventoryService.findAllImportInventory();
    }

    @PostMapping(value="/import-product")
    public ImportInventory importInventorySingleProduct(@RequestBody ImportInventory importInventory){
            return importInventoryService.saveProductImportInventory(importInventory);
    }

    @GetMapping(value = "/import-product/{id}")
    public ImportInventory getImportInventoryById(@PathVariable("id")Integer id){
        return importInventoryService.findImportInventoryById(id);
    }

    @PutMapping(value = "/update-product/{id}")
    public ImportInventory updateInventory(@PathVariable("id")Integer id,@RequestBody ImportInventory importInventory){
        if(importInventoryService.findImportInventoryById(id)!=null){
            importInventoryService.updateImportInventory(importInventory);
        }
        return null;
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteImportInventoryById(@PathVariable("id")Integer id){
        if(importInventoryService.findImportInventoryById(id)!=null){
            importInventoryService.deleteImportInventoryById(id);
            return "Xóa thành công!";
        }
        return "Xóa thất bại!";
    }
}
