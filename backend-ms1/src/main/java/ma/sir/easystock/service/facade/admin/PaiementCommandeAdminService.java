package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.PaiementCommande;
import ma.sir.easystock.dao.criteria.core.PaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementCommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.PaiementCommandeDto;
import org.springframework.http.HttpEntity;

public interface PaiementCommandeAdminService extends  IService<PaiementCommande,PaiementCommandeCriteria, PaiementCommandeHistoryCriteria>  {

    List<PaiementCommande> findByCommandeId(Long id);
    int deleteByCommandeId(Long id);
    List<PaiementCommande> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementCommande> findByEtatPaiementCommandeId(Long id);
    int deleteByEtatPaiementCommandeId(Long id);

    HttpEntity<byte[]> createPdf(PaiementCommandeDto dto) throws Exception;


}
