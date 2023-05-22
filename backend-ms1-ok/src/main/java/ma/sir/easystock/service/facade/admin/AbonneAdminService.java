package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Abonne;
import ma.sir.easystock.dao.criteria.core.AbonneCriteria;
import ma.sir.easystock.dao.criteria.history.AbonneHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.AbonneDto;
import org.springframework.http.HttpEntity;

public interface AbonneAdminService extends  IService<Abonne,AbonneCriteria, AbonneHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(AbonneDto dto) throws Exception;


}
