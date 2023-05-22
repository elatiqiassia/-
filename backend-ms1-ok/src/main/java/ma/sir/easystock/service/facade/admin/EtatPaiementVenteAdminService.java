package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiementVente;
import ma.sir.easystock.dao.criteria.core.EtatPaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementVenteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatPaiementVenteDto;
import org.springframework.http.HttpEntity;

public interface EtatPaiementVenteAdminService extends  IService<EtatPaiementVente,EtatPaiementVenteCriteria, EtatPaiementVenteHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatPaiementVenteDto dto) throws Exception;


}
