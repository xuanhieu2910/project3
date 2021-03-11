package xuanhieu.project3.service;
import xuanhieu.project3.entity.Customer;
import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomer();

    Customer findCustomerById(Integer id);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);
}
