package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatAchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatAchatHistoryDao extends AbstractHistoryRepository<EtatAchatHistory,Long> {

}
