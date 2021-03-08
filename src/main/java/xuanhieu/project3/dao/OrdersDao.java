package xuanhieu.project3.dao;
import xuanhieu.project3.entity.Orders;

import java.util.*;
public interface OrdersDao {

    List<Orders>findAllOrders();

    Orders findOrdersById(Integer id);

    Orders saveOrders(Orders orders);

    String deleteOrdersById(Integer id);
}
