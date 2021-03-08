package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.project3.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
