package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Livraison;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LivraisonDao extends AbstractRepository<Livraison,Long>  {

    List<Livraison> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    List<Livraison> findByEtatLivraisonId(Long id);
    int deleteByEtatLivraisonId(Long id);
    List<Livraison> findByClientId(Long id);
    int deleteByClientId(Long id);

}
