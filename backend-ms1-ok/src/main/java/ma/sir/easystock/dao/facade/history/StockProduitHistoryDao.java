package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.StockProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StockProduitHistoryDao extends AbstractHistoryRepository<StockProduitHistory,Long> {

}
