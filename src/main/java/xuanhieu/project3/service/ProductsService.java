package xuanhieu.project3.service;

import xuanhieu.project3.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    //lưu
    Products saveProducts(Products products);
    //tìm
    Products findProductById(Integer id);
    //lấy tất cả
    List<Products> findAllProducts();
    //Chỉnh sửa
    Products updateProducts(Products products);
    //Xóa
    void deleteProductById(Integer id);
}
