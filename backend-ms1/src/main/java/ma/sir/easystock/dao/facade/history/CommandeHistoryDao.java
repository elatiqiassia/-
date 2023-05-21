package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.CommandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeHistoryDao extends AbstractHistoryRepository<CommandeHistory,Long> {

}
