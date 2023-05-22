package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.CommandeItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CommandeItemDao extends AbstractRepository<CommandeItem,Long>  {

    List<CommandeItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<CommandeItem> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);

}
