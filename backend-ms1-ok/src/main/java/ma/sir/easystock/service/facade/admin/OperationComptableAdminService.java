package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.OperationComptable;
import ma.sir.easystock.dao.criteria.core.OperationComptableCriteria;
import ma.sir.easystock.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.OperationComptableDto;
import org.springframework.http.HttpEntity;

public interface OperationComptableAdminService extends  IService<OperationComptable,OperationComptableCriteria, OperationComptableHistoryCriteria>  {

    List<OperationComptable> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<OperationComptable> findByCompteComptableId(Long id);
    int deleteByCompteComptableId(Long id);

    HttpEntity<byte[]> createPdf(OperationComptableDto dto) throws Exception;


}
