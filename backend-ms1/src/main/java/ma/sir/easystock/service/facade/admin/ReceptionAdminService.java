package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Reception;
import ma.sir.easystock.dao.criteria.core.ReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ReceptionDto;
import org.springframework.http.HttpEntity;

public interface ReceptionAdminService extends  IService<Reception,ReceptionCriteria, ReceptionHistoryCriteria>  {

    List<Reception> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    List<Reception> findByEtatReceptionId(Long id);
    int deleteByEtatReceptionId(Long id);

    HttpEntity<byte[]> createPdf(ReceptionDto dto) throws Exception;


}
