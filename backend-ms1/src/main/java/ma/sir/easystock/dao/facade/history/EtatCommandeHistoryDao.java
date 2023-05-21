package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatCommandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCommandeHistoryDao extends AbstractHistoryRepository<EtatCommandeHistory,Long> {

}
