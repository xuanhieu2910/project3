package xuanhieu.project3.dao;

import xuanhieu.project3.entity.Products;

import java.util.List;

public interface ProductsDao {
    //lưu
    Products saveProducts(Products products);
    //tìm
    Products findProductById(Integer id);
    //lấy tất cả
    List<Products> findAllProducts();
    //Chỉnh sửa
    Products updateProducts(Products products);
    //Xóa
    String deleteProductById(Integer id);


    List<Products>findAllProductByIdSupplier(Integer id);

}
