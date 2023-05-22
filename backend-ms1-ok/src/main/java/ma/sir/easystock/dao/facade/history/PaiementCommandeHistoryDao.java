package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementCommandeHistoryDao extends AbstractHistoryRepository<PaiementCommandeHistory,Long> {

}
