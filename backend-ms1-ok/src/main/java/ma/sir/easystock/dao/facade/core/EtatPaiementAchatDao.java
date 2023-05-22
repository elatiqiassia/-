package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatPaiementAchat;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatPaiementAchat;
import java.util.List;


@Repository
public interface EtatPaiementAchatDao extends AbstractRepository<EtatPaiementAchat,Long>  {
    EtatPaiementAchat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatPaiementAchat(item.id,item.libelle) FROM EtatPaiementAchat item")
    List<EtatPaiementAchat> findAllOptimized();
}
