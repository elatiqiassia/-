package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.OperationComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationComptableHistoryDao extends AbstractHistoryRepository<OperationComptableHistory,Long> {

}
