package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatLivraisonHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatLivraisonHistoryDao extends AbstractHistoryRepository<EtatLivraisonHistory,Long> {

}
