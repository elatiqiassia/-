package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ReceptionItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionItemHistoryDao extends AbstractHistoryRepository<ReceptionItemHistory,Long> {

}
