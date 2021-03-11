package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xuanhieu.project3.entity.Inventory;
import java.util.*;
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    @Query("SELECT iv FROM Inventory iv WHERE iv.products.idProduct=:idProduct and iv.branchInventory.idBranchInventory=:idBranch")
    List<Inventory> findInventoryByIdProduct(@Param("idProduct")Integer idProduct,@Param("idBranch")Integer idBranch);


//    Inventory updateInventoryByIdProduct()

    @Query("SELECT iv FROM Inventory iv WHERE iv.products.idProduct=:id")
    List<Inventory>findInventoriesByIdProduct(@Param("id")Integer id);

}
