package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatAvoirAchat;
import ma.sir.easystock.dao.criteria.core.EtatAvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatAvoirAchatDto;
import org.springframework.http.HttpEntity;

public interface EtatAvoirAchatAdminService extends  IService<EtatAvoirAchat,EtatAvoirAchatCriteria, EtatAvoirAchatHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatAvoirAchatDto dto) throws Exception;


}
