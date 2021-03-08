package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.ImportInventoryDao;
import xuanhieu.project3.entity.BranchInventory;
import xuanhieu.project3.entity.ImportInventory;
import xuanhieu.project3.entity.Inventory;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.service.BranchInventoryService;
import xuanhieu.project3.service.ImportInventoryService;
import xuanhieu.project3.service.InventoryService;
import xuanhieu.project3.service.ProductsService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class ImportInventoryServiceImpl implements ImportInventoryService {

    public static Products products;
    public static Date dateImport;
    public static BranchInventory branchInventory;
    public static List<ImportInventory>importInventories;
    public static Inventory inventory;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Autowired
    ImportInventoryDao importInventoryDao;

    @Autowired
    ProductsService productsService;

    @Autowired
    BranchInventoryService branchInventoryService;

    @Autowired
    InventoryService inventoryService;



    @Override
    public List<ImportInventory> findAllImportInventory() {
        return importInventoryDao.findAllImportInventory();
    }

    @Override
    public ImportInventory saveSingleProductImportInventory(Integer id,ImportInventory importInventory) {
//         TH : đã có sản phẩm trong kho
//         logic : Sản phẩm đã nằm trong kho thì phải có chi nhánh
//         Yêu cầu: Kiểm tra có sản phẩm đấy ko  + Xem nó nằm trong chi nhanh nào -> cập nhập lại số lượng
//         Số lượng mới  = số lượng có trong kho hiện tại + số lượng nhập ko
//
//         1. Kiểm tra có sản phẩm trong kho?

        Date importDate = new Date();
        String date = simpleDateFormat.format(importDate);

        if(productsService.findProductById(id)!=null){
            products = productsService.findProductById(id);
            importInventories = new ArrayList<>();
            if(importInventory.getEnable()==1){
                branchInventory = new BranchInventory();
                branchInventory.setImportInventory(importInventory);
                products.setQuantity(importInventory.getQuantity());
                products.setDateImport(date);
            }
            importInventoryDao.saveImportInventory(importInventory);
            saveProductIntoInventory(products);

            return importInventory;
        }
        else{
            return null;
        }
    }

    private void saveProductIntoInventory(Products products){
        productsService.updateProducts(products);
    }

    @Override
    public ImportInventory findImportInventoryById(Integer id) {
        return importInventoryDao.findImportInventoryById(id);
    }

    @Override
    public ImportInventory updateImportInventory(ImportInventory importInventory) {
        return importInventoryDao.saveImportInventory(importInventory);
    }

    @Override
    public String deleteImportInventoryById(Integer id) {
        if(importInventoryDao.deleteImportInventoryById(id)!=null){
            importInventoryDao.deleteImportInventoryById(id);
            return "Xóa thành công!";
        }
        else{
            return null;
        }
    }




    @Override
    public ImportInventory importNewProductIntoImportInventory(Products products) {
        return null;
    }
}
