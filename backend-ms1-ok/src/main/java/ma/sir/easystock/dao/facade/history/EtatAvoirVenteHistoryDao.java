package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatAvoirVenteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatAvoirVenteHistoryDao extends AbstractHistoryRepository<EtatAvoirVenteHistory,Long> {

}
