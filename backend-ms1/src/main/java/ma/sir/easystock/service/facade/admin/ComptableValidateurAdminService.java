package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ComptableValidateur;
import ma.sir.easystock.dao.criteria.core.ComptableValidateurCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableValidateurHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ComptableValidateurDto;
import org.springframework.http.HttpEntity;

public interface ComptableValidateurAdminService extends  IService<ComptableValidateur,ComptableValidateurCriteria, ComptableValidateurHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ComptableValidateurDto dto) throws Exception;


}
