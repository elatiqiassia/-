package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.AvoirVente;
import ma.sir.easystock.dao.criteria.core.AvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirVenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.AvoirVenteDto;
import org.springframework.http.HttpEntity;

public interface AvoirVenteAdminService extends  IService<AvoirVente,AvoirVenteCriteria, AvoirVenteHistoryCriteria>  {

    List<AvoirVente> findByVenteId(Long id);
    int deleteByVenteId(Long id);
    List<AvoirVente> findByEtatAvoirVenteId(Long id);
    int deleteByEtatAvoirVenteId(Long id);

    HttpEntity<byte[]> createPdf(AvoirVenteDto dto) throws Exception;


}
