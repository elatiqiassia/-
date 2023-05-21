package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatLivraison;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatLivraison;
import java.util.List;


@Repository
public interface EtatLivraisonDao extends AbstractRepository<EtatLivraison,Long>  {
    EtatLivraison findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatLivraison(item.id,item.libelle) FROM EtatLivraison item")
    List<EtatLivraison> findAllOptimized();
}
