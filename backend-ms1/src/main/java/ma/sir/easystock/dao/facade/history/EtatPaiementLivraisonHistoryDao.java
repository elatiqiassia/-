package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.EtatPaiementLivraisonHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatPaiementLivraisonHistoryDao extends AbstractHistoryRepository<EtatPaiementLivraisonHistory,Long> {

}
