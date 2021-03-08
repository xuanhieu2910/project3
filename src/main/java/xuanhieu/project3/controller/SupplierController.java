package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.Supplier;
import xuanhieu.project3.service.SupplierService;
import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class SupplierController {

    @Autowired
    SupplierService supplierService;



    @GetMapping("/suppliers")
    public List<Supplier>getAllSupplier(){
        return supplierService.findAllSupplier();
    }

    @PostMapping("/save-supplier")
    public Supplier saveSupplier(@RequestBody Supplier supplier){
        return  supplierService.saveSupplier(supplier);
    }

    @GetMapping("/supplier/{id}")
    public Supplier getSupplierById(@PathVariable("id")Integer id){
        return supplierService.findSupplierByIdSupplier(id);
    }

    @PutMapping("/update-supplier/{id}")
    public Supplier updateSupplierById(@PathVariable("id")Integer id,@RequestBody Supplier supplier){
        if(supplierService.findSupplierByIdSupplier(id)!=null){
            return supplierService.updateSupplier(id,supplier);
        }
        else{
            return null;
        }
    }

    @DeleteMapping("/delete-supplier/{id}")
    public String deleteSupplierById(@PathVariable("id")Integer id){
        supplierService.deleteSupplierById(id);
        return "Xóa thành công!";
    }
}
