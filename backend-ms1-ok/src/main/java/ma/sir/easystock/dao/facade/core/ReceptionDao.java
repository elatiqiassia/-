package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Reception;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Reception;
import java.util.List;


@Repository
public interface ReceptionDao extends AbstractRepository<Reception,Long>  {
    Reception findByReference(String reference);
    int deleteByReference(String reference);

    List<Reception> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    List<Reception> findByEtatReceptionId(Long id);
    int deleteByEtatReceptionId(Long id);

    @Query("SELECT NEW Reception(item.id,item.reference) FROM Reception item")
    List<Reception> findAllOptimized();
}
