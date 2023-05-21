package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatDemandeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDemandeHistoryDao extends AbstractHistoryRepository<EtatDemandeHistory,Long> {

}
