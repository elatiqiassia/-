package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.OperationComptable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OperationComptableDao extends AbstractRepository<OperationComptable,Long>  {

    List<OperationComptable> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<OperationComptable> findByCompteComptableId(Long id);
    int deleteByCompteComptableId(Long id);

}
