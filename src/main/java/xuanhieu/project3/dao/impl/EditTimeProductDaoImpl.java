package xuanhieu.project3.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xuanhieu.project3.dao.EditTimeProductDao;
import xuanhieu.project3.entity.EditTimeProduct;
import xuanhieu.project3.repository.EditTimeProductRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class EditTimeProductDaoImpl implements EditTimeProductDao {

    @Autowired
    EditTimeProductRepository editTimeProductRepository;

    @Override
    public List<EditTimeProduct> findAllTimeEditProduct() {
        return editTimeProductRepository.findAll();
    }

    @Override
    public EditTimeProduct findEditTimeById(Integer id) {
        Optional<EditTimeProduct> editTimeProduct = editTimeProductRepository.findById(id);
        if(editTimeProduct.isPresent()){
            return editTimeProduct.get();
        }
        return null;
    }
}
