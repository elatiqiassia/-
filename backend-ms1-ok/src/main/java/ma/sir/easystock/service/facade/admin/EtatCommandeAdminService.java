package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatCommande;
import ma.sir.easystock.dao.criteria.core.EtatCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatCommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatCommandeDto;
import org.springframework.http.HttpEntity;

public interface EtatCommandeAdminService extends  IService<EtatCommande,EtatCommandeCriteria, EtatCommandeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception;


}
