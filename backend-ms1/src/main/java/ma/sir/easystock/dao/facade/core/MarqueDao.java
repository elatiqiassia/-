package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Marque;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Marque;
import java.util.List;


@Repository
public interface MarqueDao extends AbstractRepository<Marque,Long>  {
    Marque findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Marque(item.id,item.libelle) FROM Marque item")
    List<Marque> findAllOptimized();
}
