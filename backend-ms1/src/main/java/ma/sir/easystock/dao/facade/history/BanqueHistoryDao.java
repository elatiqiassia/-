package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.BanqueHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BanqueHistoryDao extends AbstractHistoryRepository<BanqueHistory,Long> {

}
