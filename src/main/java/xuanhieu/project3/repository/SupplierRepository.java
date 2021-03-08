package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xuanhieu.project3.entity.Products;
import xuanhieu.project3.entity.Supplier;
import java.util.*;
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {


    @Query("SELECT sl FROM Supplier sl where  sl.idSupplier=:id")
    Supplier findSupplierByIdSupplier(@Param("id")Integer id);

//    @Query("SELECT sl FROM Supplier sl WHERE sl.")
//    List<Products> findAllProductByIdSupplier();
}
