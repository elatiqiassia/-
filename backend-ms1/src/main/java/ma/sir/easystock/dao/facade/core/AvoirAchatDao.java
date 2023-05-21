package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.AvoirAchat;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirAchatDao extends AbstractRepository<AvoirAchat,Long>  {

    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    List<AvoirAchat> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);

}
