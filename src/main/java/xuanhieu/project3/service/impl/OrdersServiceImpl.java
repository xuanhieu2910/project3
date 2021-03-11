package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.OrdersDao;
import xuanhieu.project3.entity.*;
import xuanhieu.project3.service.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

    public static Payment payment;
    public static List<OrderDetails> orderDetailsList;
    public static OrderDetails orderDetails;
    public static Integer idProduct;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static Date dateOrder;
    public static Integer idOrder;
    public static int size;
//    public static HashMap<String, Integer>keyHashMap;
    public static List<Integer>listIdInventory;
    public static int sizeOrder;




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
//    private boolean checkProductIntoInventory(Integer idProduct){
//        if(productsService.findProductById(idProduct)!=null){
//            return true;
//        }
//        return false;
//            return false;
//    }
//
//    private boolean checkQuantityOfProductIntoInventory(Integer idProduct,List<OrderDetails>orderDetails){
//       int totalQuantityInventory = 0;
//       int totalQuantityOrderDetails=orderDetails.get(0).getQuantity();
//        inventories = inventoryService.findInventoryByIdProduct(idProduct);
//        size = inventories.size();
//       for(int i=0;i<size;i++){
//           totalQuantityInventory+= inventories.get(i).getTotalSales();
//       }
//       if(totalQuantityInventory<totalQuantityOrderDetails){
//           return false;
//       }
//       return true;
//    }
//
//    private float totalPrice(Integer idProduct,List<OrderDetails>orderDetails){
//        float   totalPrice = productsService.findProductById(idProduct).getPrice() * orderDetails.get(0).getQuantity();
//        return totalPrice;
//    }
//
//    private int totalQuantity(List<OrderDetails>orderDetails){
//        int totalQuantity = orderDetails.get(0).getQuantity();
//        return totalQuantity;
//    }
//
//    @Override
//    public Orders saveOrders(Integer idOrder,Orders orders) {
////
////            if(  (checkInventory(orders.getOrderDetailsList())) &&
////    @Override
////    public Orders saveOrders(Integer idProduct,Orders orders) {
////
////                 ){
////                //TH chưa có
////                if(ordersService.findOrdersById(idOrder)==null){
////
////            if(  (checkProductIntoInventory(idProduct)) &&
////                    checkQuantityOfProductIntoInventory(idProduct,orders.getOrderDetailsList())){
////                dateOrder = new Date();
////                String date  = simpleDateFormat.format(dateOrder);
////                    orderDetailsList = new ArrayList<>();
////                    priceOfProduct = productsService.findProductById(idProduct).getPrice();
////
////                    System.out.println(orders.getOrderDetailsList().size());
////
////                    for(int i=0;i<orders.getOrderDetailsList().size();i++){
////                        totalQuantity+=orders.getOrderDetailsList().get(i).getQuantity();
////                    }
////                    System.out.println(priceOfProduct);
////                    System.out.println(totalQuantity);
////                    orders.setTotalPrice(totalQuantity*priceOfProduct);
////                    totalQuantity = totalQuantity(orders.getOrderDetailsList());
////                    priceOfProduct = totalPrice(idProduct,orders.getOrderDetailsList());
////                System.out.println("Step 2:"+totalQuantity + priceOfProduct);
////                    orders.setDateOrder(date);
////                    orders.setTotalQuantity(totalQuantity);
////                    orders.setId(idOrder);
////
////                    orders.setTotalPrice(priceOfProduct);
////                    for(int i=0;i<orders.getOrderDetailsList().size();i++){
////                        orderDetails = orders.getOrderDetailsList().get(i);
////
////                        orderDetails = new OrderDetails();;
////                        orderDetails.setQuantity(totalQuantity);
////                        orderDetails.setOrders(orders);
////                        orderDetails.setProductsDetails(productsService.findProductById(idProduct));
////                        System.out.println("ALALALAL"+productsService.findProductById(idProduct).getNameProduct());
////                        orderDetailsList.add(orderDetails);
////                    }
////                    productsService.findProductById(idProduct).setOrderDetails(orderDetailsList);
////                    orders.setOrderDetailsList(orderDetailsList);
////                    shipService.saveShip(orders.getShip());
////                    customerService.saveCustomer(orders.getCustomer());
////                    paymentService.savePayment(orders.getPayment());
////                    System.out.println("hahaha");
////                    ship = orders.getShip();
////                    customer =orders.getCustomer();
////                    payment = orders.getPayment();
////                    orders.setShip(ship);
////                    orders.setPayment(payment);
////                    orders.setCustomer(customer);
////                    ordersDao.saveOrders(orders);
////                }
////                else{
////
////
////                }
////            return orders;
////    }
////
////            }
//        return orders;
//    }


//


    @Override
    public String deleteOrdersById(Integer id) {
        if (ordersDao.deleteOrdersById(id) == null) {
            return "Xoa that bai";
        }

        return "Xoa thanh cong!";
    }


    // Bat dau lam ban nayf

    // Check xem sản phẩm đó có trong kho không
    private boolean checkProductInventory(List<OrderDetails> listOrderDetails) {
        System.out.println(listOrderDetails.size());
        for (int i = 0; i < listOrderDetails.size(); i++) {
            Integer id = listOrderDetails.get(i).getProductsDetails().getIdProduct();
            System.out.println(productsService.findProductById(id).getNameProduct());
            if (productsService.findProductById(id) == null) {
                return false;
            }
        }
        return true;
    }

    // Check số lượng trong kho xem còn không?
    private boolean checkQuantityInventoryWithIdProduct(List<OrderDetails> orderDetails) {
        int totalQuantity;
        int totalQuantityInventory = 0;
        for (int i = 0; i < orderDetails.size(); i++) {
            int id = orderDetails.get(i).getProductsDetails().getIdProduct();
            totalQuantity = orderDetails.get(i).getQuantity();
            List<Inventory> inventories = inventoryService.findInventoryByIdProduct(id);
            for (int j = 0; j < inventories.size(); j++) {
                totalQuantityInventory += inventories.get(i).getTotalSales();
            }
            System.out.println(totalQuantity + " ; " + totalQuantityInventory);
            if (totalQuantity > totalQuantityInventory) {
                return false;
            }

        }
        return true;
    }

    // Tổng thành tiền trong đơn hàng
    private float priceOfOrder(List<OrderDetails> orderDetails) {

        float priceOfOrder = 0;

        for (int i = 0; i < orderDetails.size(); i++) {
            int idProduct = orderDetails.get(i).getProductsDetails().getIdProduct();
            priceOfOrder += productsService.findProductById(idProduct).getPrice() * orderDetails.get(i).getQuantity();
        }
        System.out.println(priceOfOrder);
        return priceOfOrder;
    }

    // Lấy ra tổng số lượng trong đơn hàng
    private int quantityOrder(List<OrderDetails> orderDetails) {
        int quantity = 0;

        for (int i = 0; i < orderDetails.size(); i++) {
            quantity += orderDetails.get(i).getQuantity();
        }
        System.out.println(quantity);
        return quantity;
    }

    // Check vận chuyển cho đơn hàng
    private boolean checkShip(Ship shipOrder) {
        if (shipOrder.getEnable() == 1) {
            return true;
        }
        return false;

    }

    // Check thanh toán cho đơn hàng
    private boolean checkPayment(Payment paymentOrder) {
        if (paymentOrder.getEnable() == 1) {
            return true;
        }
        return false;
    }

    // Đặt trạng thái cho đơn hàng
    private String checkStatusOrder(Orders orders) {
        System.out.println(orders.getShip()!=null);
        if (orders.getShip() != null) {
            if ((!checkShip(orders.getShip())) && (!checkPayment(orders.getPayment()))) {
                return "Thanh toán khi giao hàng";
            } else if (!checkShip(orders.getShip()) && checkPayment(orders.getPayment())) {
                return "Đã thanh toán,chờ giao hàng!";
            }
            else if(checkShip(orders.getShip()) && checkPayment(orders.getPayment())){
                return "Đã thanh toán + giao hang!";
            }
            else if(checkShip(orders.getShip()) &&!checkPayment(orders.getPayment())){
                return "Đã giao hàng, chờ thanh toán";
            }
        } else {
            if (checkPayment(orders.getPayment())) {
                return "Đã thanh toán";
            } else {
                return "Chưa thanh toán";
            }
        }
        return null;
    }





    @Override
    public Orders saveOrders(Orders orders) {
        sizeOrder = orders.getOrderDetailsList().size();

        if (checkProductInventory(orders.getOrderDetailsList()) && checkQuantityInventoryWithIdProduct(orders.getOrderDetailsList())) {
            orders.setStatus(checkStatusOrder(orders));
            System.out.println(checkStatusOrder(orders));
            dateOrder = new Date();
            String date = simpleDateFormat.format(dateOrder);
            orders.setDateOrder(date);
            orders.setTotalPrice(priceOfOrder(orders.getOrderDetailsList()));
            orders.setTotalQuantity(quantityOrder(orders.getOrderDetailsList()));
            orderDetailsList = new ArrayList<>();
            for (int i = 0; i < sizeOrder; i++) {
                orderDetails = orders.getOrderDetailsList().get(i);
                orderDetails.setOrders(orders);
                orderDetailsList.add(orderDetails);
            }
            paymentService.savePayment(orders.getPayment());
            customerService.saveCustomer(orders.getCustomer());
            shipService.saveShip(orders.getShip());
            orders.setOrderDetailsList(orderDetailsList);
            // Trường hợp có giao hàng ---> Vẫn có lấy hàng  --> Liên quan tới việc ưu tiên sản phẩm -->> Đợi bên vận chuyển
            // xác nhận xem giao hàng xong chưa, chưa giao hàng xong
            // Còn giao hàng ko thành công --> Trả hàng lại
            try {
                updateInventory(orders.getOrderDetailsList(),checkTimeProductIntoInventory(orders.getOrderDetailsList()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return ordersDao.saveOrders(orders);
        }

        return null;
    }


    private void updateInventory(List<OrderDetails>orderDetailsLis,List<Integer>integers){
        for(int i=0;i<orderDetailsLis.size();i++){
            Integer id = orderDetailsLis.get(i).getProductsDetails().getIdProduct();
            List<Inventory>inventories = inventoryService.findInventoryByIdProduct(id);
            for(int j=0;j<inventories.size();j++){
                if(inventories.get(i).getIdInventory().equals(integers.get(i))){
                    Inventory inventory = inventories.get(i);
                    inventory.setTotalSales(inventory.getTotalSales() - orderDetailsLis.get(i).getQuantity());
                    inventoryService.saveInventory(inventory);
                }
            }
        }
    }

    // Check thời gian, ưu tiên sản phẩm nhập trước
    private List<Integer> checkTimeProductIntoInventory(List<OrderDetails> orderDetails) throws ParseException {
//        HashMap<String, Integer> keyInventory = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        for (int i = 0; i < orderDetails.size(); i++) {
            int id = orderDetails.get(i).getProductsDetails().getIdProduct();
            List<Inventory>inventoriesList = inventoryService.findInventoryByIdProduct(id);
            Date date = simpleDateFormat.parse(inventoriesList.get(0).getDateImport());
            for(int j=1;j< inventoriesList.size();i++){
                Date date1 = simpleDateFormat.parse(inventoriesList.get(j).getDateImport());
                if(date.compareTo(date1)>0){
                    date = date1;
                }
            }
            String minTime = simpleDateFormat.format(date);
            for(int h =0;h<inventoriesList.size();h++){
                if(minTime.equals(inventoriesList.get(i).getDateImport())){
//                    keyInventory.put(minTime,inventoriesList.get(i).getIdInventory());
                    list.add(inventoriesList.get(i).getIdInventory());
                }
            }
        }
        return list;
    }
}
