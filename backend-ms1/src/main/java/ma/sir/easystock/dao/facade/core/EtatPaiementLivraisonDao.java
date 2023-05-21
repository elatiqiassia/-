package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import java.util.List;


@Repository
public interface EtatPaiementLivraisonDao extends AbstractRepository<EtatPaiementLivraison,Long>  {
    EtatPaiementLivraison findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatPaiementLivraison(item.id,item.libelle) FROM EtatPaiementLivraison item")
    List<EtatPaiementLivraison> findAllOptimized();
}
