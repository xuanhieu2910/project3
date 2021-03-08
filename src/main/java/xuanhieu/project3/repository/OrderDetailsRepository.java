package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.project3.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {
}
