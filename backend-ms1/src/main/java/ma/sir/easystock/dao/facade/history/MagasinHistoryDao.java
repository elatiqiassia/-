package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.MagasinHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface MagasinHistoryDao extends AbstractHistoryRepository<MagasinHistory,Long> {

}
