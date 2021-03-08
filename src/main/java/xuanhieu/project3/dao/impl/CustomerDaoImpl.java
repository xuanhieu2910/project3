package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.CustomerDao;
import xuanhieu.project3.entity.Customer;
import xuanhieu.project3.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }


    @Override
    public Customer findCustomerById(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }
        return null;
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public void deleteCustomerById(Integer id) {
        Optional<Customer>customer = customerRepository.findById(id);
        if(customer.isPresent()){
            customerRepository.deleteById(id);
        }
        else{
            System.out.println("Don't delete Object");
        }
    }
}
