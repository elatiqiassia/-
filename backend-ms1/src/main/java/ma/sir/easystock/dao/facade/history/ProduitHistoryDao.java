package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitHistoryDao extends AbstractHistoryRepository<ProduitHistory,Long> {

}
