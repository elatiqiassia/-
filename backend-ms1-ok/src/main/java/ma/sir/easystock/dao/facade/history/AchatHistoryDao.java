package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatHistoryDao extends AbstractHistoryRepository<AchatHistory,Long> {

}
