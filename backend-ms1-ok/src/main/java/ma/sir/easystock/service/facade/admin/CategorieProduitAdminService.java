package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.CategorieProduit;
import ma.sir.easystock.dao.criteria.core.CategorieProduitCriteria;
import ma.sir.easystock.dao.criteria.history.CategorieProduitHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.CategorieProduitDto;
import org.springframework.http.HttpEntity;

public interface CategorieProduitAdminService extends  IService<CategorieProduit,CategorieProduitCriteria, CategorieProduitHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(CategorieProduitDto dto) throws Exception;


}
