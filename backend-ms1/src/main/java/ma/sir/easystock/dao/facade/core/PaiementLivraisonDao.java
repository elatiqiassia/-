package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.PaiementLivraison;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.PaiementLivraison;
import java.util.List;


@Repository
public interface PaiementLivraisonDao extends AbstractRepository<PaiementLivraison,Long>  {
    PaiementLivraison findByReference(String reference);
    int deleteByReference(String reference);

    List<PaiementLivraison> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);
    List<PaiementLivraison> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    List<PaiementLivraison> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementLivraison> findByEtatPaiementLivraisonId(Long id);
    int deleteByEtatPaiementLivraisonId(Long id);

    @Query("SELECT NEW PaiementLivraison(item.id,item.reference) FROM PaiementLivraison item")
    List<PaiementLivraison> findAllOptimized();
}
