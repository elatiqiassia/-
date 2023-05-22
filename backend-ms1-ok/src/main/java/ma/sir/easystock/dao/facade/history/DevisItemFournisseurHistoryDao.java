package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.DevisItemFournisseurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DevisItemFournisseurHistoryDao extends AbstractHistoryRepository<DevisItemFournisseurHistory,Long> {

}
