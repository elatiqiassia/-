package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.PaiementLivraison;
import ma.sir.easystock.dao.criteria.core.PaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.PaiementLivraisonHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.PaiementLivraisonDto;
import org.springframework.http.HttpEntity;

public interface PaiementLivraisonAdminService extends  IService<PaiementLivraison,PaiementLivraisonCriteria, PaiementLivraisonHistoryCriteria>  {

    List<PaiementLivraison> findByLivraisonId(Long id);
    int deleteByLivraisonId(Long id);
    List<PaiementLivraison> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    List<PaiementLivraison> findByModePaiementId(Long id);
    int deleteByModePaiementId(Long id);
    List<PaiementLivraison> findByEtatPaiementLivraisonId(Long id);
    int deleteByEtatPaiementLivraisonId(Long id);

    HttpEntity<byte[]> createPdf(PaiementLivraisonDto dto) throws Exception;


}
