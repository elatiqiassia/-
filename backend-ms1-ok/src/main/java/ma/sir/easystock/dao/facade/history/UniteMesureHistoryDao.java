package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.UniteMesureHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteMesureHistoryDao extends AbstractHistoryRepository<UniteMesureHistory,Long> {

}
