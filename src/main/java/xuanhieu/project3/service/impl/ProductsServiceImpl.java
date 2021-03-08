package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.ProductsDao;
import xuanhieu.project3.entity.*;
import xuanhieu.project3.repository.ProductsRepository;
import xuanhieu.project3.service.BranchInventoryService;
import xuanhieu.project3.service.ProductsService;
import xuanhieu.project3.service.SupplierService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    public static List<Products> productsList;
    public static Date dateImportProduct;
    public static Date dateEditProduct;
    public static List<EditTimeProduct> editTimeProductList;
    public static List<Inventory> inventories;
    public static List<BranchInventory> branchInventories;
    public static Inventory inventory;
    public static ImportInventory importInventory;
    public static List<ImportInventory> importInventories;
    public static BranchInventory branchInventory;
    public static String expiryDate;
    public static Integer totalInventory;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateCheck = "01/01/2021";
    @Autowired
    SupplierService supplierService;

    @Autowired
    ProductsDao productsDao;

    @Autowired
    BranchInventoryService branchInventoryService;

    public boolean checkTime(String dateImport, String dateOfManufacture) throws ParseException {
        Date date1 = simpleDateFormat.parse(dateImport);
        Date date2 = simpleDateFormat.parse(dateOfManufacture);
        Date root = simpleDateFormat.parse(dateCheck);
        int day1 = (int) ((date1.getTime() - root.getTime()) / (1000 * 60 * 60 * 24));
        int day2 = (int) ((date2.getTime() - root.getTime()) / (1000 * 60 * 60 * 24));
        System.out.println(day2+";"+day1);
        if (day1 - day2 < 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean checkQuantity(Integer totalInventory, Integer root) {
        if (root > totalInventory) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBranchInventory(Integer id){
        if(branchInventoryService.findBranchInventoryById(id)!=null){
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public Products saveProducts(Products products) {

        // Check time
        dateImportProduct = new Date();
        String date = simpleDateFormat.format(dateImportProduct);
        System.out.println(date+"\n");
        try {
            if (!checkTime(date, products.getDateOfManufacture())) {
                return null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        products.setDateImport(dateImportProduct.toString());
        productsList = new ArrayList<>();
        inventories = new ArrayList<>();

        //check số lượng
        Integer root = products.getQuantity();
        for (int i = 0; i < products.getInventories().size(); i++) {
            totalInventory = products.getInventories().get(i).getTotalInventory();
            if(!checkQuantity(totalInventory,root)){
                totalInventory=root;
            }
            root-=totalInventory;
            Inventory inventory = new Inventory(totalInventory, totalInventory, date, products.getExpirationDate());
            inventory.setProducts(products);
            inventory.setBranchInventory(products.getInventories().get(i).getBranchInventory());
            System.out.println("haha");
            //Check chi nhánh nhà kho
            if(!checkBranchInventory(products.getInventories().get(i).getBranchInventory().getIdBranchInventory())){
                branchInventoryService.saveBranchInventory(products.getInventories().get(i).getBranchInventory());
            }
            inventories.add(inventory);
            products.getInventories().get(i).getBranchInventory().setInventories(inventories);
        }
        products.setInventories(inventories);
        productsList.add(products);
        products.getSupplier().setProductsList(productsList);
        supplierService.saveSupplier(products.getSupplier());
        return products;
    }


    @Override
    public Products findProductById(Integer id) {
        return productsDao.findProductById(id);
    }

    @Override
    public List<Products> findAllProducts() {
        return productsDao.findAllProducts();
    }

    @Override
    public Products updateProducts(Products products) {
        dateEditProduct = new Date();
        EditTimeProduct editTimeProduct = new EditTimeProduct();
        editTimeProduct.setDateEdit(dateEditProduct.toString());
        editTimeProduct.setProducts_time(products);
        editTimeProduct.setStatus("Chỉnh sửa sản phẩm");
        editTimeProductList = new ArrayList<>();
        editTimeProductList.add(editTimeProduct);
        products.setEditTimeProduct(editTimeProductList);
        return productsDao.updateProducts(products);
    }

    @Override
    public void deleteProductById(Integer id) {
        productsDao.deleteProductById(id);
    }
}
