package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.TauxRetardTva;
import ma.sir.easystock.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.easystock.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

public interface TauxRetardTvaAdminService extends  IService<TauxRetardTva,TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception;


}
