package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.PaiementDemandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDemandeHistoryDao extends AbstractHistoryRepository<PaiementDemandeHistory,Long> {

}
