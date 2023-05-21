package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Banque;
import ma.sir.easystock.dao.criteria.core.BanqueCriteria;
import ma.sir.easystock.dao.criteria.history.BanqueHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.BanqueDto;
import org.springframework.http.HttpEntity;

public interface BanqueAdminService extends  IService<Banque,BanqueCriteria, BanqueHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(BanqueDto dto) throws Exception;


}
