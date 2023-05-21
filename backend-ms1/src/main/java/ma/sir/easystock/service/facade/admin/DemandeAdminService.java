package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.DemandeDto;
import org.springframework.http.HttpEntity;

public interface DemandeAdminService extends  IService<Demande,DemandeCriteria, DemandeHistoryCriteria>  {

    List<Demande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demande> findByEtatDemandeId(Long id);
    int deleteByEtatDemandeId(Long id);

    HttpEntity<byte[]> createPdf(DemandeDto dto) throws Exception;


}
