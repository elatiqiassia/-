package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ReceptionItem;
import ma.sir.easystock.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.easystock.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ReceptionItemDto;
import org.springframework.http.HttpEntity;

public interface ReceptionItemAdminService extends  IService<ReceptionItem,ReceptionItemCriteria, ReceptionItemHistoryCriteria>  {

    List<ReceptionItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<ReceptionItem> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<ReceptionItem> findByReceptionId(Long id);
    int deleteByReceptionId(Long id);

    HttpEntity<byte[]> createPdf(ReceptionItemDto dto) throws Exception;


}
