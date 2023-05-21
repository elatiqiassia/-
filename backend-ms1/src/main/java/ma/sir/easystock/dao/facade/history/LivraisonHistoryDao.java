package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.LivraisonHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonHistoryDao extends AbstractHistoryRepository<LivraisonHistory,Long> {

}
