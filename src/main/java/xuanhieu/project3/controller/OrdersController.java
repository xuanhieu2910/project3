package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.Orders;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.service.OrdersService;

import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class OrdersController {


    @Autowired
    OrdersService ordersService;

    @GetMapping(value = "/orders")
    public List<Orders>getAllOrders(){
        return ordersService.findAllOrders();
    }



    @PostMapping(value="/addOrders/{idOrder}/")
    public Orders addOrders(@PathVariable("idOrder")Integer idOrder, @RequestBody Orders orders){
        return ordersService.saveOrders(idOrder,orders);
    }

    @GetMapping(value = "/order/{id}")
    public Orders findOrdersById(@PathVariable("id")Integer id){
        return ordersService.findOrdersById(id);
    }
}
