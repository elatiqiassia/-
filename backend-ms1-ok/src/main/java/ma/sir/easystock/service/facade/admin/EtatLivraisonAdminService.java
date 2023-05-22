package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatLivraison;
import ma.sir.easystock.dao.criteria.core.EtatLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.EtatLivraisonHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatLivraisonDto;
import org.springframework.http.HttpEntity;

public interface EtatLivraisonAdminService extends  IService<EtatLivraison,EtatLivraisonCriteria, EtatLivraisonHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatLivraisonDto dto) throws Exception;


}
