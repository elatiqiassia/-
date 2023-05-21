package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.CompteComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteComptableHistoryDao extends AbstractHistoryRepository<CompteComptableHistory,Long> {

}
