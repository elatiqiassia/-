package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Vente;
import ma.sir.easystock.dao.criteria.core.VenteCriteria;
import ma.sir.easystock.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.VenteDto;
import org.springframework.http.HttpEntity;

public interface VenteAdminService extends  IService<Vente,VenteCriteria, VenteHistoryCriteria>  {

    List<Vente> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<Vente> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Vente> findByEtatVenteId(Long id);
    int deleteByEtatVenteId(Long id);

    HttpEntity<byte[]> createPdf(VenteDto dto) throws Exception;


}
