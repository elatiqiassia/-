package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatVente;
import ma.sir.easystock.dao.criteria.core.EtatVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatVenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatVenteDto;
import org.springframework.http.HttpEntity;

public interface EtatVenteAdminService extends  IService<EtatVente,EtatVenteCriteria, EtatVenteHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception;


}
