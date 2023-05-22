package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ComptableTraitant;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.ComptableTraitant;
import java.util.List;


@Repository
public interface ComptableTraitantDao extends AbstractRepository<ComptableTraitant,Long>  {
    ComptableTraitant findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW ComptableTraitant(item.id,item.cin) FROM ComptableTraitant item")
    List<ComptableTraitant> findAllOptimized();
}
