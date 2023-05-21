package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.DevisFournisseur;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.DevisFournisseur;
import java.util.List;


@Repository
public interface DevisFournisseurDao extends AbstractRepository<DevisFournisseur,Long>  {
    DevisFournisseur findByReference(String reference);
    int deleteByReference(String reference);

    List<DevisFournisseur> findByFournisseurId(Long id);
    int deleteByFournisseurId(Long id);

    @Query("SELECT NEW DevisFournisseur(item.id,item.reference) FROM DevisFournisseur item")
    List<DevisFournisseur> findAllOptimized();
}
