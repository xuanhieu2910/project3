package xuanhieu.project3.dao;

import xuanhieu.project3.entity.Customer;

import java.util.List;

public interface CustomerDao {

    Customer saveCustomer(Customer customer);

    List<Customer> findAllCustomer();

    Customer findCustomerById(Integer id);

    Customer updateCustomer(Customer customer);

    void deleteCustomerById(Integer id);
}
