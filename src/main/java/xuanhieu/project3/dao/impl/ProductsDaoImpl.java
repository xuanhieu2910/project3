package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.ProductsDao;
import xuanhieu.project3.dao.SupplierDao;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.repository.ProductsRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductsDaoImpl implements ProductsDao {
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    SupplierDao supplierDao;


    @Override
    public Products saveProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products findProductById(Integer id) {
        Optional<Products> products = productsRepository.findById(id);
        if(products.isPresent()){
            return products.get();
        }
        else{
            return null;
        }
    }

    @Override
    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products updateProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public String deleteProductById(Integer id) {
        Optional<Products>products = productsRepository.findById(id);
        if(products.isPresent()){
            productsRepository.deleteById(id);
            return "Xóa thành công";
        }
        else{
            return "Xóa thất bại";
        }
    }

    @Override
    public List<Products> findAllProductByIdSupplier(Integer id) {
        if(supplierDao.findSupplierByIdSupplier(id)!=null) {
            return productsRepository.getProductsByIdSupplier(id);
        }
        else{
            return null;
        }
    }
}
