package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatAvoirVente;
import ma.sir.easystock.dao.criteria.core.EtatAvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirVenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatAvoirVenteDto;
import org.springframework.http.HttpEntity;

public interface EtatAvoirVenteAdminService extends  IService<EtatAvoirVente,EtatAvoirVenteCriteria, EtatAvoirVenteHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatAvoirVenteDto dto) throws Exception;


}
