package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ReceptionHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionHistoryDao extends AbstractHistoryRepository<ReceptionHistory,Long> {

}
