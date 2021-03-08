package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.OrdersDao;
import xuanhieu.project3.entity.Orders;
import xuanhieu.project3.repository.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrdersDao {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders findOrdersById(Integer id) {
        Optional<Orders>orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            return orders.get();
        }
        return null;
    }

    @Override
    public Orders saveOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public String deleteOrdersById(Integer id) {
        Optional<Orders>orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            return "Xoa thanh cong!";
        }
        return null;
    }
}
