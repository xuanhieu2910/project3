package xuanhieu.project3.dao;
import xuanhieu.project3.entity.EditTimeProduct;

import java.util.*;
public interface EditTimeProductDao {

    List<EditTimeProduct> findAllTimeEditProduct();

    EditTimeProduct findEditTimeById(Integer id);
}
