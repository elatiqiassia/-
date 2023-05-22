package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ComptableTraitant;
import ma.sir.easystock.dao.criteria.core.ComptableTraitantCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableTraitantHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ComptableTraitantDto;
import org.springframework.http.HttpEntity;

public interface ComptableTraitantAdminService extends  IService<ComptableTraitant,ComptableTraitantCriteria, ComptableTraitantHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ComptableTraitantDto dto) throws Exception;


}
