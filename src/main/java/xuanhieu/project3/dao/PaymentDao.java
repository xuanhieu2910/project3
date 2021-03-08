package xuanhieu.project3.dao;

import xuanhieu.project3.entity.Payment;

import java.util.List;

public interface PaymentDao {

    List<Payment> findAllPayment();

    Payment savePayment(Payment payment);

    Payment findPaymentById(Integer id);

    String deletePaymentById(Integer id);
}
