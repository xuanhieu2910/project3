package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.PaymentDao;
import xuanhieu.project3.entity.Payment;
import xuanhieu.project3.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PaymentDaoImpl implements PaymentDao {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findPaymentById(Integer id) {
        Optional<Payment>payment = paymentRepository.findById(id);
        if(payment.isPresent()){
            return payment.get();
        }
        return null;
    }

    @Override
    public String deletePaymentById(Integer id) {
        Optional<Payment>payment = paymentRepository.findById(id);
        if(payment.isPresent()){
            paymentRepository.deleteById(id);
            return "Xóa thành công!";
        }
        return null;
    }
}
