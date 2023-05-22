package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatPaiementCommandeHistoryDao extends AbstractHistoryRepository<EtatPaiementCommandeHistory,Long> {

}
