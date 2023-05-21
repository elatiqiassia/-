package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.EtatAvoirAchat;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.EtatAvoirAchat;
import java.util.List;


@Repository
public interface EtatAvoirAchatDao extends AbstractRepository<EtatAvoirAchat,Long>  {
    EtatAvoirAchat findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW EtatAvoirAchat(item.id,item.libelle) FROM EtatAvoirAchat item")
    List<EtatAvoirAchat> findAllOptimized();
}
