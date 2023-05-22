package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.PaiementVenteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementVenteHistoryDao extends AbstractHistoryRepository<PaiementVenteHistory,Long> {

}
