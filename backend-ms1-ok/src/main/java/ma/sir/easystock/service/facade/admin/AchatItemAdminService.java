package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.AchatItem;
import ma.sir.easystock.dao.criteria.core.AchatItemCriteria;
import ma.sir.easystock.dao.criteria.history.AchatItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.AchatItemDto;
import org.springframework.http.HttpEntity;

public interface AchatItemAdminService extends  IService<AchatItem,AchatItemCriteria, AchatItemHistoryCriteria>  {

    List<AchatItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<AchatItem> findByAchatId(Long id);
    int deleteByAchatId(Long id);

    HttpEntity<byte[]> createPdf(AchatItemDto dto) throws Exception;


}
