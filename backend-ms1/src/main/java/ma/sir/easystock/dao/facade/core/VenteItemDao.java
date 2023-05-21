package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.VenteItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VenteItemDao extends AbstractRepository<VenteItem,Long>  {

    List<VenteItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<VenteItem> findByVenteId(Long id);
    int deleteByVenteId(Long id);

}
