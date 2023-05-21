package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.VenteItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteItemHistoryDao extends AbstractHistoryRepository<VenteItemHistory,Long> {

}
