package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.CommandeItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeItemHistoryDao extends AbstractHistoryRepository<CommandeItemHistory,Long> {

}
