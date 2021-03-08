package xuanhieu.project3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xuanhieu.project3.dao.EditTimeProductDao;
import xuanhieu.project3.entity.EditTimeProduct;
import xuanhieu.project3.service.EditTimeProductService;

import java.util.List;
@Service
public class EditTimeProductServiceImpl  implements EditTimeProductService {
    @Autowired
    EditTimeProductDao editTimeProductDao;
    @Override
    public List<EditTimeProduct> findAllTimeEditProduct() {
        return editTimeProductDao.findAllTimeEditProduct();
    }

    @Override
    public EditTimeProduct findEditTimeById(Integer id) {
        return editTimeProductDao.findEditTimeById(id);
    }
}
