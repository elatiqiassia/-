package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.StoreHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHistoryDao extends AbstractHistoryRepository<StoreHistory,Long> {

}
