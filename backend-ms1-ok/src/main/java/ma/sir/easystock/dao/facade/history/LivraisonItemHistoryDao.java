package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.LivraisonItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonItemHistoryDao extends AbstractHistoryRepository<LivraisonItemHistory,Long> {

}
