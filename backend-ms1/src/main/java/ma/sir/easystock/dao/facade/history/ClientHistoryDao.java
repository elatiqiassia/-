package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ClientHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientHistoryDao extends AbstractHistoryRepository<ClientHistory,Long> {

}
