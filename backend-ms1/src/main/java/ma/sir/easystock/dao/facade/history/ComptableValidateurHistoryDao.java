package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptableValidateurHistoryDao extends AbstractHistoryRepository<ComptableValidateurHistory,Long> {

}
