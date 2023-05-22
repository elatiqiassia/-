package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatAchat;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatAchat;
import java.util.List;


@Repository
public interface EtatAchatDao extends AbstractRepository<EtatAchat,Long>  {
    EtatAchat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatAchat(item.id,item.libelle) FROM EtatAchat item")
    List<EtatAchat> findAllOptimized();
}
