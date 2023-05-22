package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import ma.sir.easystock.dao.criteria.core.EtatPaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementLivraisonHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatPaiementLivraisonDto;
import org.springframework.http.HttpEntity;

public interface EtatPaiementLivraisonAdminService extends  IService<EtatPaiementLivraison,EtatPaiementLivraisonCriteria, EtatPaiementLivraisonHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatPaiementLivraisonDto dto) throws Exception;


}
