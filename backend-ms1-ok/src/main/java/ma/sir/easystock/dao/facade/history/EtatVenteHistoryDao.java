package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatVenteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatVenteHistoryDao extends AbstractHistoryRepository<EtatVenteHistory,Long> {

}
