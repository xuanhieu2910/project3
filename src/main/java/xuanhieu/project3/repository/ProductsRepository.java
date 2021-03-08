package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import xuanhieu.project3.entity.Products;

import javax.annotation.security.PermitAll;
import java.util.*;
public interface ProductsRepository extends JpaRepository<Products,Integer> {

    @Query("SELECT pd FROM Products pd WHERE  pd.idProduct=:id")
    Products getProductsByIdProduct(@Param("id")Integer id);

    @Query("SELECT pd FROM Products pd WHERE pd.supplier.idSupplier=:id")
    List<Products>getProductsByIdSupplier(@Param("id")Integer id);
}
