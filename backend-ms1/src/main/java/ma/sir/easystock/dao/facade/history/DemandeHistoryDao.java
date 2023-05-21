package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.DemandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeHistoryDao extends AbstractHistoryRepository<DemandeHistory,Long> {

}
