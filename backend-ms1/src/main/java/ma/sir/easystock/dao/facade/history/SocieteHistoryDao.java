package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.SocieteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteHistoryDao extends AbstractHistoryRepository<SocieteHistory,Long> {

}
