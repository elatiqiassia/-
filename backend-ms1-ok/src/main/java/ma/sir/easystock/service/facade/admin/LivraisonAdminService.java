package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.dao.criteria.core.LivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.LivraisonDto;
import org.springframework.http.HttpEntity;

public interface LivraisonAdminService extends  IService<Livraison,LivraisonCriteria, LivraisonHistoryCriteria>  {

    List<Livraison> findByDemandeId(Long id);
    int deleteByDemandeId(Long id);
    List<Livraison> findByEtatLivraisonId(Long id);
    int deleteByEtatLivraisonId(Long id);
    List<Livraison> findByClientId(Long id);
    int deleteByClientId(Long id);

    HttpEntity<byte[]> createPdf(LivraisonDto dto) throws Exception;


}
