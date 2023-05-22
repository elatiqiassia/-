package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.BilanHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanHistoryDao extends AbstractHistoryRepository<BilanHistory,Long> {

}
