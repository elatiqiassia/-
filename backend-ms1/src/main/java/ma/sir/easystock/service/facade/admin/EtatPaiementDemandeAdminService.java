package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiementDemande;
import ma.sir.easystock.dao.criteria.core.EtatPaiementDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementDemandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatPaiementDemandeDto;
import org.springframework.http.HttpEntity;

public interface EtatPaiementDemandeAdminService extends  IService<EtatPaiementDemande,EtatPaiementDemandeCriteria, EtatPaiementDemandeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatPaiementDemandeDto dto) throws Exception;


}
