package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Demande;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Demande;
import java.util.List;


@Repository
public interface DemandeDao extends AbstractRepository<Demande,Long>  {
    Demande findByReference(String reference);
    int deleteByReference(String reference);

    List<Demande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);

    @Query("SELECT NEW Demande(item.id,item.reference) FROM Demande item")
    List<Demande> findAllOptimized();
}
