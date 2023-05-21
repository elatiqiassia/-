package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.AbonneHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonneHistoryDao extends AbstractHistoryRepository<AbonneHistory,Long> {

}
