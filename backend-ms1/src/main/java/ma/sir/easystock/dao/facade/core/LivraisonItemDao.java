package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.LivraisonItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LivraisonItemDao extends AbstractRepository<LivraisonItem,Long>  {

    List<LivraisonItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<LivraisonItem> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<LivraisonItem> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);

}
