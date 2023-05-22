package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ClassComptable;
import ma.sir.easystock.dao.criteria.core.ClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ClassComptableDto;
import org.springframework.http.HttpEntity;

public interface ClassComptableAdminService extends  IService<ClassComptable,ClassComptableCriteria, ClassComptableHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ClassComptableDto dto) throws Exception;


}
