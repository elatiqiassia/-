package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.AvoirAchatItem;
import ma.sir.easystock.dao.criteria.core.AvoirAchatItemCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirAchatItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.AvoirAchatItemDto;
import org.springframework.http.HttpEntity;

public interface AvoirAchatItemAdminService extends  IService<AvoirAchatItem,AvoirAchatItemCriteria, AvoirAchatItemHistoryCriteria>  {

    List<AvoirAchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<AvoirAchatItem> findByAvoirAchatId(Long id);
    int deleteByAvoirAchatId(Long id);

    HttpEntity<byte[]> createPdf(AvoirAchatItemDto dto) throws Exception;


}
