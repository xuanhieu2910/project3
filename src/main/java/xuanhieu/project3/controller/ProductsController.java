package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.*;
import xuanhieu.project3.service.EditTimeProductService;
import xuanhieu.project3.service.ProductsService;

import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @Autowired
    EditTimeProductService editTimeProductService;


    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return productsService.findAllProducts();
    }

    @PostMapping("/create-product")
    public Products createProducts(@RequestBody Products products){
        return productsService.saveProducts(products);
    }

    @GetMapping("/product/{id}")
    public Products findProductById(@PathVariable("id")Integer id){
        return productsService.findProductById(id);
    }

    @PutMapping("/update-product/{id}")
    public Products updateProduct(@PathVariable("id")Integer id,@RequestBody Products products){
            if(productsService.findProductById(id)!=null){
               return  productsService.updateProducts(products);
            }
            else{
                return null;
            }
    }


    @DeleteMapping("/delete-product/{id}")
    public String deleteProductById(@PathVariable("id")Integer id){
        productsService.deleteProductById(id);
        return "Xóa thành công!";
    }

    @GetMapping("/history-edit")
    public List<EditTimeProduct>getAllEditTimeProducts(){
        return editTimeProductService.findAllTimeEditProduct();

    }

    @GetMapping("/history-edit/{id}")
    public EditTimeProduct editTimeProduct(@PathVariable("id")Integer id){
        return editTimeProductService.findEditTimeById(id);
    }
}
