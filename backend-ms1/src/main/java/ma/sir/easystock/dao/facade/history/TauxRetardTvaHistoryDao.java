package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxRetardTvaHistoryDao extends AbstractHistoryRepository<TauxRetardTvaHistory,Long> {

}
