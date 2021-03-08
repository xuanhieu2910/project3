package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.project3.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
