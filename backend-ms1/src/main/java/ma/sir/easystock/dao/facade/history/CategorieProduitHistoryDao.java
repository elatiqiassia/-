package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.CategorieProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieProduitHistoryDao extends AbstractHistoryRepository<CategorieProduitHistory,Long> {

}
