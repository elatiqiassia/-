package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AvoirVenteItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AvoirVenteItemHistoryDao extends AbstractHistoryRepository<AvoirVenteItemHistory,Long> {

}
