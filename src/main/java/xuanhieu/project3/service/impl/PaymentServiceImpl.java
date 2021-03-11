package xuanhieu.project3.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.PaymentDao;
import xuanhieu.project3.entity.Payment;
import xuanhieu.project3.service.PaymentService;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public List<Payment> findAllPayment() {
        return paymentDao.findAllPayment();
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentDao.savePayment(payment);
    }

    @Override
    public Payment findPaymentById(Integer id) {
        return paymentDao.findPaymentById(id);
    }

    @Override
    public String deletePaymentById(Integer id) {
        if(paymentDao.deletePaymentById(id)!=null){
            return "Xóa thành công";
        }
        return null;
    }
}
