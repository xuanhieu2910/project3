package xuanhieu.project3.service;
import xuanhieu.project3.entity.EditTimeProduct;
import java.util.List;

public interface EditTimeProductService {
    List<EditTimeProduct> findAllTimeEditProduct();

    EditTimeProduct findEditTimeById(Integer id);
}
