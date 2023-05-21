package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Fournisseur;
import ma.sir.easystock.dao.criteria.core.FournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.FournisseurDto;
import org.springframework.http.HttpEntity;

public interface FournisseurAdminService extends  IService<Fournisseur,FournisseurCriteria, FournisseurHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception;


}
