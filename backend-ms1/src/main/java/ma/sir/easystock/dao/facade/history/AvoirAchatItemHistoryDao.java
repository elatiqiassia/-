package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AvoirAchatItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AvoirAchatItemHistoryDao extends AbstractHistoryRepository<AvoirAchatItemHistory,Long> {

}
