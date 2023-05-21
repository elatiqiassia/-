package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Societe;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Societe;
import java.util.List;


@Repository
public interface SocieteDao extends AbstractRepository<Societe,Long>  {
    Societe findByIce(String ice);
    int deleteByIce(String ice);

    List<Societe> findByAbonneId(Long id);
    int deleteByAbonneId(Long id);

    @Query("SELECT NEW Societe(item.id,item.ice) FROM Societe item")
    List<Societe> findAllOptimized();
}
