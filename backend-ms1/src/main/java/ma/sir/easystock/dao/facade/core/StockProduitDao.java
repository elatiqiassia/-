package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.StockProduit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StockProduitDao extends AbstractRepository<StockProduit,Long>  {

    List<StockProduit> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<StockProduit> findByProduitId(Long id);
    int deleteByProduitId(Long id);

}
