package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatReception;
import ma.sir.easystock.dao.criteria.core.EtatReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.EtatReceptionHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.EtatReceptionDto;
import org.springframework.http.HttpEntity;

public interface EtatReceptionAdminService extends  IService<EtatReception,EtatReceptionCriteria, EtatReceptionHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatReceptionDto dto) throws Exception;


}
