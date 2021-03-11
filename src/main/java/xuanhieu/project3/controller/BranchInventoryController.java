package xuanhieu.project3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xuanhieu.project3.entity.BranchInventory;
import xuanhieu.project3.service.BranchInventoryService;


import java.util.*;
@RestController
@RequestMapping(name = "/api")
public class BranchInventoryController {

    @Autowired
    BranchInventoryService branchInventoryService;

    @GetMapping(value = "/branch")
    public List<BranchInventory>getAllInventory(){
        return branchInventoryService.findAllBranchInventory();
    }

    @PostMapping(value = "/save-branch")
    public BranchInventory saveBranchInventory(@RequestBody BranchInventory branchInventory){
        return branchInventoryService.saveBranchInventory(branchInventory);
    }


    @GetMapping(value = "/branch-inventory/{id}")
    public BranchInventory getBranchInventoryById(@PathVariable("id")Integer id){
        return branchInventoryService.findBranchInventoryById(id);
    }

    @PutMapping(value = "/update-branch/{id}")
    public BranchInventory updateBranchInventoryById(@PathVariable("id")Integer id,@RequestBody BranchInventory branchInventory){
        if(branchInventoryService.findBranchInventoryById(id)!=null){
           return  branchInventoryService.updateBranchInventory(branchInventory);
        }
        else{
            System.out.println("Chưa có chi nhánh!");
            return null;
        }
    }
    @DeleteMapping(value = "/delete-branch/{id}")
    public String deleteBranchInventoryById(@PathVariable("id")Integer id){
        if(branchInventoryService.deleteBranchInventoryById(id).equals("Xóa thành công!")){
           return branchInventoryService.deleteBranchInventoryById(id);
        }
        else{
            return "Xóa thất bại";
        }
    }

}
