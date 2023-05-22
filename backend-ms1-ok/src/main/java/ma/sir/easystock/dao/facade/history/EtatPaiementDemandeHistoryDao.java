package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatPaiementDemandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatPaiementDemandeHistoryDao extends AbstractHistoryRepository<EtatPaiementDemandeHistory,Long> {

}
