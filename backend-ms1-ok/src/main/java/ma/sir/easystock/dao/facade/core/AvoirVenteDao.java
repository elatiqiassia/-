package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.AvoirVente;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AvoirVenteDao extends AbstractRepository<AvoirVente,Long>  {

    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    List<AvoirVente> findByEtatAvoirVenteId(Long id);
    int deleteByEtatAvoirVenteId(Long id);

}
