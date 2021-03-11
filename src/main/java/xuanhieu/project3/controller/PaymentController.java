package xuanhieu.project3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.Payment;
import xuanhieu.project3.service.PaymentService;
import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class PaymentController {

    @Autowired
    PaymentService  paymentService;

    @GetMapping(value = "/payments")
    public List<Payment>getAllPayment(){
        return paymentService.findAllPayment();
    }

    @GetMapping(value = "/payment/{id}")
    public Payment getPaymentById(@PathVariable("id")Integer id){
        if(paymentService.findPaymentById(id)!=null){
            return paymentService.findPaymentById(id);
        }
        return null;
    }


    @PostMapping(value = "/create-payment")
    public Payment createPayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }
}
