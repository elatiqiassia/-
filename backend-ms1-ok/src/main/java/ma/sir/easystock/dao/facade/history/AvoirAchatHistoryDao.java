package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AvoirAchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AvoirAchatHistoryDao extends AbstractHistoryRepository<AvoirAchatHistory,Long> {

}
