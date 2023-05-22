package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatAchat;
import ma.sir.easystock.dao.criteria.core.EtatAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatAchatDto;
import org.springframework.http.HttpEntity;

public interface EtatAchatAdminService extends  IService<EtatAchat,EtatAchatCriteria, EtatAchatHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception;


}
