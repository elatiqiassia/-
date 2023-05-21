package ma.sir.easystock.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.Produit;
import org.springframework.stereotype.Repository;
import ma.sir.easystock.bean.core.Produit;
import java.util.List;


@Repository
public interface ProduitDao extends AbstractRepository<Produit,Long>  {
    Produit findByReference(String reference);
    int deleteByReference(String reference);

    List<Produit> findByCategorieProduitId(Long id);
    int deleteByCategorieProduitId(Long id);
    List<Produit> findByUniteMesureId(Long id);
    int deleteByUniteMesureId(Long id);
    List<Produit> findByMarqueId(Long id);
    int deleteByMarqueId(Long id);
    List<Produit> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    @Query("SELECT NEW Produit(item.id,item.libelle) FROM Produit item")
    List<Produit> findAllOptimized();
}
