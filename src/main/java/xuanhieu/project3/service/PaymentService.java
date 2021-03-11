package xuanhieu.project3.service;
import xuanhieu.project3.entity.Payment;
import java.util.*;
public interface PaymentService {

    List<Payment>findAllPayment();

    Payment savePayment(Payment payment);

    Payment findPaymentById(Integer id);

    String deletePaymentById(Integer id);

}
