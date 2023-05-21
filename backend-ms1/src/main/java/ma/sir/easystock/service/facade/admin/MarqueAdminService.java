package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Marque;
import ma.sir.easystock.dao.criteria.core.MarqueCriteria;
import ma.sir.easystock.dao.criteria.history.MarqueHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.MarqueDto;
import org.springframework.http.HttpEntity;

public interface MarqueAdminService extends  IService<Marque,MarqueCriteria, MarqueHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(MarqueDto dto) throws Exception;


}
