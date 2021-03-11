package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.CustomerDao;
import xuanhieu.project3.entity.Customer;
import xuanhieu.project3.service.CustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;



    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }
}
