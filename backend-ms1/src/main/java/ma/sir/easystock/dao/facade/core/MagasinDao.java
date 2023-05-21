package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Magasin;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Magasin;
import java.util.List;


@Repository
public interface MagasinDao extends AbstractRepository<Magasin,Long>  {
    Magasin findByReference(String reference);
    int deleteByReference(String reference);

    List<Magasin> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    @Query("SELECT NEW Magasin(item.id,item.reference) FROM Magasin item")
    List<Magasin> findAllOptimized();
}
