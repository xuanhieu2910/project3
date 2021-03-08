package xuanhieu.project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xuanhieu.project3.entity.Ship;

public interface ShipRepository extends JpaRepository<Ship,Integer> {
}
