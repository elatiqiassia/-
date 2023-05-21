package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ComptableValidateur;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.ComptableValidateur;
import java.util.List;


@Repository
public interface ComptableValidateurDao extends AbstractRepository<ComptableValidateur,Long>  {
    ComptableValidateur findByCin(String cin);
    int deleteByCin(String cin);


    @Query("SELECT NEW ComptableValidateur(item.id,item.cin) FROM ComptableValidateur item")
    List<ComptableValidateur> findAllOptimized();
}
