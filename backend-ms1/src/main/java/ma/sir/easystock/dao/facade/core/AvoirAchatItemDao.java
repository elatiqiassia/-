package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.AvoirAchatItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirAchatItemDao extends AbstractRepository<AvoirAchatItem,Long>  {

    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);

}
