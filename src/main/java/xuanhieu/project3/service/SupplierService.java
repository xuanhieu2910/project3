package xuanhieu.project3.service;
import xuanhieu.project3.entity.Supplier;
import java.util.*;
public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier>findAllSupplier();

    Supplier findSupplierByIdSupplier(Integer id);

    Supplier updateSupplier(Integer id,Supplier supplier);

    void deleteSupplierById(Integer id);
}
