package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.SupplierDao;
import xuanhieu.project3.entity.Supplier;
import xuanhieu.project3.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class SupplierDaoImpl implements SupplierDao {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> findAllSupplier() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findSupplierByIdSupplier(Integer id) {
        Optional<Supplier>supplier = supplierRepository.findById(id);
        if(supplier.isPresent()){
            return supplier.get();
        }
        return null;
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public String deleteSupplierById(Integer id) {
        Optional<Supplier>optionalSupplier = supplierRepository.findById(id);
        if(optionalSupplier.isPresent()){
            supplierRepository.deleteById(id);
            return "Xóa thành công";
        }
        else{
            return "Xóa thất bại";
        }
    }
}
