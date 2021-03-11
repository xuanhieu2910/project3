package xuanhieu.project3.service;
import xuanhieu.project3.entity.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> findAllOrders();

    Orders findOrdersById(Integer id);

//    Orders saveOrders(Integer idOrder,Orders orders);

    String deleteOrdersById(Integer id);

    Orders saveOrders(Orders orders);
}
