package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.CompteComptable;
import ma.sir.easystock.dao.criteria.core.CompteComptableCriteria;
import ma.sir.easystock.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.CompteComptableDto;
import org.springframework.http.HttpEntity;

public interface CompteComptableAdminService extends  IService<CompteComptable,CompteComptableCriteria, CompteComptableHistoryCriteria>  {

    List<CompteComptable> findBySousClassComptableId(Long id);
    int deleteBySousClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(CompteComptableDto dto) throws Exception;


}
