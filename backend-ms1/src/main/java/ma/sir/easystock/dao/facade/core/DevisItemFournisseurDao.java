package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.DevisItemFournisseur;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DevisItemFournisseurDao extends AbstractRepository<DevisItemFournisseur,Long>  {

    List<DevisItemFournisseur> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<DevisItemFournisseur> findByDevisFournisseurId(Long id);
    int deleteByDevisFournisseurId(Long id);

}
