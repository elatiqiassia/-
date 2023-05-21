package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ModePaiementHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ModePaiementHistoryDao extends AbstractHistoryRepository<ModePaiementHistory,Long> {

}
