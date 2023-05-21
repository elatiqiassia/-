package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatPaiementAchat;
import ma.sir.easystock.dao.criteria.core.EtatPaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatPaiementAchatDto;
import org.springframework.http.HttpEntity;

public interface EtatPaiementAchatAdminService extends  IService<EtatPaiementAchat,EtatPaiementAchatCriteria, EtatPaiementAchatHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatPaiementAchatDto dto) throws Exception;


}
