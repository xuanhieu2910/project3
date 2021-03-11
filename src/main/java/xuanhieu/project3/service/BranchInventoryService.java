package xuanhieu.project3.service;
import xuanhieu.project3.entity.BranchInventory;
import java.util.List;

public interface BranchInventoryService {

    List<BranchInventory> findAllBranchInventory();

    BranchInventory saveBranchInventory(BranchInventory branchInventory);

    BranchInventory findBranchInventoryById(Integer id);

    String deleteBranchInventoryById(Integer id);

    BranchInventory updateBranchInventory(BranchInventory branchInventory);
}
