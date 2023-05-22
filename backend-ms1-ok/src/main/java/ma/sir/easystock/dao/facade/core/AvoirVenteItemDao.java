package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.AvoirVenteItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirVenteItemDao extends AbstractRepository<AvoirVenteItem,Long>  {

    List<AvoirVenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<AvoirVenteItem> findByAvoirVenteId(Long id);
    int deleteByAvoirVenteId(Long id);

}
