package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.project3.entity.BranchInventory;

public interface BranchInventoryRepository extends JpaRepository<BranchInventory,Integer> {
}
