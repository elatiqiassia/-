package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.LivraisonItem;
import ma.sir.easystock.dao.criteria.core.LivraisonItemCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonItemHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.LivraisonItemDto;
import org.springframework.http.HttpEntity;

public interface LivraisonItemAdminService extends  IService<LivraisonItem,LivraisonItemCriteria, LivraisonItemHistoryCriteria>  {

    List<LivraisonItem> findByProduitId(Long id);
    int deleteByProduitId(Long id);
    List<LivraisonItem> findByMagasinId(Long id);
    int deleteByMagasinId(Long id);
    List<LivraisonItem> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);

    HttpEntity<byte[]> createPdf(LivraisonItemDto dto) throws Exception;


}
