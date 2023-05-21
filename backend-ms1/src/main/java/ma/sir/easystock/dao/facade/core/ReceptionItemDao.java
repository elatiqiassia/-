package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ReceptionItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ReceptionItemDao extends AbstractRepository<ReceptionItem,Long>  {

    List<ReceptionItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<ReceptionItem> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<ReceptionItem> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);

}
