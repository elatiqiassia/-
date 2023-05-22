package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.FournisseurHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurHistoryDao extends AbstractHistoryRepository<FournisseurHistory,Long> {

}
