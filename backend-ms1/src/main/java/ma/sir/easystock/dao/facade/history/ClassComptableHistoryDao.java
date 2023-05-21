package ma.sir.easystock.dao.facade.history;

import ma.sir.easystock.zynerator.repository.AbstractHistoryRepository;
import ma.sir.easystock.bean.history.ClassComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassComptableHistoryDao extends AbstractHistoryRepository<ClassComptableHistory,Long> {

}
