package xuanhieu.project3.dao;

import xuanhieu.project3.entity.Supplier;
import java.util.*;
public interface SupplierDao {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier>findAllSupplier();

    Supplier findSupplierByIdSupplier(Integer id);

    Supplier updateSupplier(Supplier supplier);

    String deleteSupplierById(Integer id);
}
