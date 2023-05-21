package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatAvoirAchatHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatAvoirAchatHistoryDao extends AbstractHistoryRepository<EtatAvoirAchatHistory,Long> {

}
