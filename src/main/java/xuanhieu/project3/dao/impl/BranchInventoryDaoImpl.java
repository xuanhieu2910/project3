package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.BranchInventoryDao;
import xuanhieu.project3.entity.BranchInventory;
import xuanhieu.project3.repository.BranchInventoryRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class BranchInventoryDaoImpl implements BranchInventoryDao {

    @Autowired
    BranchInventoryRepository branchInventoryRepository;

    @Override
    public List<BranchInventory> findAllBranchInventory() {
        return branchInventoryRepository.findAll();
    }

    @Override
    public BranchInventory saveBranchInventory(BranchInventory branchInventory){
        return branchInventoryRepository.save(branchInventory);
    }

    @Override
    public BranchInventory findBranchInventoryById(Integer id) {
        Optional<BranchInventory>branchInventory = branchInventoryRepository.findById(id);
        if(branchInventory.isPresent()){
            return branchInventory.get();
        }
        return null;
    }

    @Override
    public String deleteBranchInventoryById(Integer id) {
        Optional<BranchInventory>branchInventory = branchInventoryRepository.findById(id);
        if(branchInventory.isPresent()){
            branchInventoryRepository.deleteById(id);
            return "Xóa thành công!";
        }
        else{
            return "Xóa thất bại!";
        }
    }

    @Override
    public BranchInventory updateBranchInventory(BranchInventory branchInventory) {
        return branchInventoryRepository.save(branchInventory);
    }
}
