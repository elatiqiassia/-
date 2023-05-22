package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiementCommande;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementCommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatPaiementCommandeDto;
import org.springframework.http.HttpEntity;

public interface EtatPaiementCommandeAdminService extends  IService<EtatPaiementCommande,EtatPaiementCommandeCriteria, EtatPaiementCommandeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatPaiementCommandeDto dto) throws Exception;


}
