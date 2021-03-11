package xuanhieu.project3.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.ProductsDao;
import xuanhieu.project3.dao.SupplierDao;
import xuanhieu.project3.entity.EditTimeProduct;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.entity.Supplier;
import xuanhieu.project3.service.SupplierService;
import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {


    public static List<Products> products;
    public static Date dateEditProductBySupplier;
    public static List<EditTimeProduct> editTimeProductList;

    @Autowired
    SupplierDao supplierDao;

    @Autowired
    ProductsDao productsDao;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierDao.saveSupplier(supplier);
    }

    @Override
    public List<Supplier> findAllSupplier() {
        return supplierDao.findAllSupplier();
    }

    @Override
    public Supplier findSupplierByIdSupplier(Integer id) {
        return supplierDao.findSupplierByIdSupplier(id);
    }

    @Override
    public Supplier updateSupplier(Integer id, Supplier supplier) {

        supplier = supplierDao.updateSupplier(supplier);
        products = productsDao.findAllProductByIdSupplier(id);
        dateEditProductBySupplier = new Date();
        EditTimeProduct editTimeProduct = new EditTimeProduct();
        editTimeProduct.setDateEdit(dateEditProductBySupplier.toString());
        editTimeProduct.setStatus("Chỉnh sửa nhà cung cấp");
        for (int i = 0; i < products.size(); i++) {
            editTimeProductList = new ArrayList<>();
            editTimeProduct.setProducts_time(products.get(i));
            editTimeProductList.add(editTimeProduct);
            products.get(i).setEditTimeProduct(editTimeProductList);
            productsDao.updateProducts(products.get(i));
        }
        return supplier;
    }

    @Override
    public void deleteSupplierById(Integer id) {
        supplierDao.deleteSupplierById(id);
    }
}
