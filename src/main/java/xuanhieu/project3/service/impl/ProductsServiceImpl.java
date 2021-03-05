package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.repository.ProductsRepository;
import xuanhieu.project3.service.ProductsService;

import java.util.List;
import java.util.Optional;

public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Products saveProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products findProductById(Integer id) {
        Optional<Products>products = productsRepository.findById(id);
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
    public void deleteProductById(Integer id) {
            Optional<Products>products = productsRepository.findById(id);
            if(products.isPresent()){
                productsRepository.deleteById(id);
            }
    }
}
