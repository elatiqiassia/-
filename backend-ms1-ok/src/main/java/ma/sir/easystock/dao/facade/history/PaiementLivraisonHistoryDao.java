package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.PaiementLivraisonHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementLivraisonHistoryDao extends AbstractHistoryRepository<PaiementLivraisonHistory,Long> {

}
