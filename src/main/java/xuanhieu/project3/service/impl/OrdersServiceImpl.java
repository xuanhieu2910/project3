package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.OrdersDao;
import xuanhieu.project3.entity.*;
import xuanhieu.project3.repository.OrdersRepository;
import xuanhieu.project3.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProductsService productsService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ShipService shipService;

    @Autowired
    PaymentService paymentService;


    public static float priceOfProduct;
    public static int totalQuantity;
    public static Customer customer;
    public static Ship ship;
    public static Payment payment;
    public static List<OrderDetails>orderDetailsList;
    public static OrderDetails orderDetails;

    @Override
    public List<Orders> findAllOrders() {
        return ordersDao.findAllOrders();
    }

    @Override
    public Orders findOrdersById(Integer id) {
        return ordersDao.findOrdersById(id);
    }

//    private boolean checkInventory(List<OrderDetails>orderDetails){
//        for(int i=0;i<orderDetails.size();i++){
//            if(inventoryService.findInventoryByIdProduct(orderDetails.get(i).getProductsDetails().getIdProduct())!=null){
//                return true;
//            }
//        }
//            return true;
//    }
//
//    private boolean checkQuantity(List<OrderDetails>orderDetails,BranchInventory branchInventory){
//        int totalInventory = 0;
//        for(int i=0;i<orderDetails.size();i++){
//            int id = orderDetails.get(i).getProductsDetails().getIdProduct();
//            totalInventory+=inventoryService.findInventoryById(id).getTotalSales();
//        }
//        if(totalInventory>0){
//            return true;
//        }
//        return false;
//    }

    @Override
    public Orders saveOrders(Integer idOrder,Orders orders) {
//
//            if(  (checkInventory(orders.getOrderDetailsList())) &&
//
//                 ){
//                //TH chưa có
//                if(ordersService.findOrdersById(idOrder)==null){
//                    orderDetailsList = new ArrayList<>();
//                    priceOfProduct = productsService.findProductById(idProduct).getPrice();
//
//                    System.out.println(orders.getOrderDetailsList().size());
//
//                    for(int i=0;i<orders.getOrderDetailsList().size();i++){
//                        totalQuantity+=orders.getOrderDetailsList().get(i).getQuantity();
//                    }
//                    System.out.println(priceOfProduct);
//                    System.out.println(totalQuantity);
//                    orders.setTotalPrice(totalQuantity*priceOfProduct);
//                    orders.setTotalQuantity(totalQuantity);
//                    orders.setId(idOrder);
//
//                    for(int i=0;i<orders.getOrderDetailsList().size();i++){
//                        orderDetails = orders.getOrderDetailsList().get(i);
//                        orderDetails.setOrders(orders);
//                        orderDetails.setProductsDetails(productsService.findProductById(idProduct));
//                        orderDetailsList.add(orderDetails);
//                    }
//                    orders.setOrderDetailsList(orderDetailsList);
//                    shipService.saveShip(orders.getShip());
//                    customerService.saveCustomer(orders.getCustomer());
//                    paymentService.savePayment(orders.getPayment());
//                    System.out.println("hahaha");
//                    ordersDao.saveOrders(orders);
//                }
//                else{
//
//
//                }
//
//            }
            return orders;
    }





    @Override
    public String deleteOrdersById(Integer id) {
        if(ordersDao.deleteOrdersById(id)==null){
            return "Xoa that bai";
        }

        return "Xoa thanh cong!";
    }
}
