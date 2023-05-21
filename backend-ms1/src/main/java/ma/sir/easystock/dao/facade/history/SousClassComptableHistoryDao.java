package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.SousClassComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SousClassComptableHistoryDao extends AbstractHistoryRepository<SousClassComptableHistory,Long> {

}
