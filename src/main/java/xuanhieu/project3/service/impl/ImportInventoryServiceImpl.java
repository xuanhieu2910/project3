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
    public static BranchInventory branchInventory;
    public static Inventory inventory;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateImportProduct;
    public static String dateExpiryProduct;
    public static float priceProduct;
    public static int quantity;



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
    public ImportInventory saveProductImportInventory(ImportInventory importInventory) {
        if( (productsService.findProductById(importInventory.getProducts().getIdProduct())!=null) &&
                (branchInventoryService.findBranchInventoryById(importInventory.getBranchInventory().getIdBranchInventory())!=null)){

            products = productsService.findProductById(importInventory.getProducts().getIdProduct());
            inventory = new Inventory();
            dateImportProduct = importInventory.getDateImport();
            quantity = importInventory.getQuantity();
            dateExpiryProduct = importInventory.getDateExpiry();
            inventory.setProducts(products);
            inventory.setBranchInventory(branchInventoryService.findBranchInventoryById(importInventory.getBranchInventory().getIdBranchInventory()));
            inventory.setTotalInventory(quantity);
            inventory.setTotalSales(quantity);
            inventory.setDateImport(dateImportProduct);
            inventory.setExpiryDate(dateExpiryProduct);
            inventory.setStatus("Hàng mới nhập");
            inventoryService.saveInventory(inventory);
            importInventory.setProducts(products);
            return importInventoryDao.saveImportInventory(importInventory);
        }
        System.out.println("Sản phẩm chưa có trong kho!");
        return null;
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

}
