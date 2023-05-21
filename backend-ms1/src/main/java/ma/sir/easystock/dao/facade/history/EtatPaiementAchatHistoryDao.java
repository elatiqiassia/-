package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatPaiementAchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatPaiementAchatHistoryDao extends AbstractHistoryRepository<EtatPaiementAchatHistory,Long> {

}
