package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ClassComptable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClassComptableDao extends AbstractRepository<ClassComptable,Long>  {


    @Query("SELECT NEW ClassComptable(item.id,item.libelle) FROM ClassComptable item")
    List<ClassComptable> findAllOptimized();
}
