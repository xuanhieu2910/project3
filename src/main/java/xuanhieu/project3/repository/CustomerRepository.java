package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import xuanhieu.project3.entity.Customer;
import java.util.*;
public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    @Query("SELECT cs FROM Customer cs WHERE cs.idCustomer=:id")
    Customer findCustomerByIdCustomer(@Param("id")Integer id);
}
