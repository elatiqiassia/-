package ma.sir.easystock.dao.facade.core;

import ma.sir.easystock.zynerator.repository.AbstractRepository;
import ma.sir.easystock.bean.core.ProprietaireChequeBanque;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProprietaireChequeBanqueDao extends AbstractRepository<ProprietaireChequeBanque,Long>  {

    List<ProprietaireChequeBanque> findByProprietaireChequeId(Long id);
    int deleteByProprietaireChequeId(Long id);
    List<ProprietaireChequeBanque> findByBanqueId(Long id);
    int deleteByBanqueId(Long id);

}
