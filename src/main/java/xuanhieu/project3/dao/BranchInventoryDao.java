package xuanhieu.project3.dao;
import xuanhieu.project3.entity.BranchInventory;

import java.util.*;
public interface BranchInventoryDao {

    List<BranchInventory>findAllBranchInventory();

    BranchInventory saveBranchInventory(BranchInventory branchInventory);

    BranchInventory findBranchInventoryById(Integer id);

    String deleteBranchInventoryById(Integer id);

    BranchInventory updateBranchInventory(BranchInventory branchInventory);
}
