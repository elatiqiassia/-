package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ModePaiement;
import ma.sir.easystock.dao.criteria.core.ModePaiementCriteria;
import ma.sir.easystock.dao.criteria.history.ModePaiementHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ModePaiementDto;
import org.springframework.http.HttpEntity;

public interface ModePaiementAdminService extends  IService<ModePaiement,ModePaiementCriteria, ModePaiementHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ModePaiementDto dto) throws Exception;


}
