package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatReception;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatReception;
import java.util.List;


@Repository
public interface EtatReceptionDao extends AbstractRepository<EtatReception,Long>  {
    EtatReception findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatReception(item.id,item.libelle) FROM EtatReception item")
    List<EtatReception> findAllOptimized();
}
