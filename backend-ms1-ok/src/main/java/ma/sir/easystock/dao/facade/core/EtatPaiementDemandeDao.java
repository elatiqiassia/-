package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatPaiementDemande;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatPaiementDemande;
import java.util.List;


@Repository
public interface EtatPaiementDemandeDao extends AbstractRepository<EtatPaiementDemande,Long>  {
    EtatPaiementDemande findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatPaiementDemande(item.id,item.libelle) FROM EtatPaiementDemande item")
    List<EtatPaiementDemande> findAllOptimized();
}
