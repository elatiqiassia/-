package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ProprietaireChequeBanqueHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireChequeBanqueHistoryDao extends AbstractHistoryRepository<ProprietaireChequeBanqueHistory,Long> {

}
