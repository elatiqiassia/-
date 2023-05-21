package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AchatItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatItemHistoryDao extends AbstractHistoryRepository<AchatItemHistory,Long> {

}
