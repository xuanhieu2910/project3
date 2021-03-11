package xuanhieu.project3.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.BranchInventoryDao;
import xuanhieu.project3.entity.BranchInventory;
import xuanhieu.project3.service.BranchInventoryService;
import java.util.List;

@Service
public class BranchInventoryServiceImpl implements BranchInventoryService {

    @Autowired
    BranchInventoryDao branchInventoryDao;

    @Override
    public List<BranchInventory> findAllBranchInventory() {
        return branchInventoryDao.findAllBranchInventory();
    }

    @Override
    public BranchInventory saveBranchInventory(BranchInventory branchInventory) {
        return branchInventoryDao.saveBranchInventory(branchInventory);
    }

    @Override
    public BranchInventory findBranchInventoryById(Integer id) {
        return branchInventoryDao.findBranchInventoryById(id);
    }

    @Override
    public String deleteBranchInventoryById(Integer id) {
        if (branchInventoryDao.deleteBranchInventoryById(id).equals("Xóa thành công!")) {
            return "Xóa thành công!";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public BranchInventory updateBranchInventory(BranchInventory branchInventory) {
        return branchInventoryDao.saveBranchInventory(branchInventory);
    }
}
