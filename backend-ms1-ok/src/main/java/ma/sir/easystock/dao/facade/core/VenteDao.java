package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Vente;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Vente;
import java.util.List;


@Repository
public interface VenteDao extends AbstractRepository<Vente,Long>  {
    Vente findByReference(String reference);
    int deleteByReference(String reference);

    List<Vente> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);

    @Query("SELECT NEW Vente(item.id,item.reference) FROM Vente item")
    List<Vente> findAllOptimized();
}
