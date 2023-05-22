package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.DemandeItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeItemHistoryDao extends AbstractHistoryRepository<DemandeItemHistory,Long> {

}
