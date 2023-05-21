package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ModePaiement;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.ModePaiement;
import java.util.List;


@Repository
public interface ModePaiementDao extends AbstractRepository<ModePaiement,Long>  {
    ModePaiement findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ModePaiement(item.id,item.libelle) FROM ModePaiement item")
    List<ModePaiement> findAllOptimized();
}
