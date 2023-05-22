package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.PaiementDemande;
import ma.sir.easystock.dao.criteria.core.PaiementDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementDemandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.PaiementDemandeDto;
import org.springframework.http.HttpEntity;

public interface PaiementDemandeAdminService extends  IService<PaiementDemande,PaiementDemandeCriteria, PaiementDemandeHistoryCriteria>  {

    List<PaiementDemande> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    List<PaiementDemande> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementDemande> findByEtatPaiementDemandeId(Long id);
    int deleteByEtatPaiementDemandeId(Long id);

    HttpEntity<byte[]> createPdf(PaiementDemandeDto dto) throws Exception;


}
