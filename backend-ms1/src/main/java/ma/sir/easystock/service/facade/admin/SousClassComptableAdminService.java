package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.SousClassComptable;
import ma.sir.easystock.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.SousClassComptableDto;
import org.springframework.http.HttpEntity;

public interface SousClassComptableAdminService extends  IService<SousClassComptable,SousClassComptableCriteria, SousClassComptableHistoryCriteria>  {

    List<SousClassComptable> findByClassComptableId(Long id);
    int deleteByClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(SousClassComptableDto dto) throws Exception;


}
