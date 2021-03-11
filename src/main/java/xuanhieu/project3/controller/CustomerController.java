package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.Customer;
import xuanhieu.project3.service.CustomerService;

import java.util.*;

@RestController
@RequestMapping(name = "/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers")
    public List<Customer> getAllCustomer() {
        return customerService.findAllCustomer();
    }

    @PostMapping(value = "/create-customer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getCustomerById(@PathVariable("id")Integer id){
        if(customerService.findCustomerById(id)!=null){
            return customerService.findCustomerById(id);
        }
        return null;
    }


    @PutMapping(value = "/update-customer/{id}")
    public Customer updateCustomer(@PathVariable("id")Integer id,@RequestBody Customer customer){
        if(customerService.findCustomerById(id)!=null){
            return customerService.updateCustomer(customer);
        }
        return null;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteCustomerById(@PathVariable("id")Integer id){
        if(customerService.findCustomerById(id)!=null){
            customerService.deleteCustomerById(id);
            return "Xóa thành công!";
        }
        return "Xóa thất bại";
    }
}
