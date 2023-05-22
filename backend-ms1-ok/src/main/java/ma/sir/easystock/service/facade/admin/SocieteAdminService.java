package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Societe;
import ma.sir.easystock.dao.criteria.core.SocieteCriteria;
import ma.sir.easystock.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.SocieteDto;
import org.springframework.http.HttpEntity;

public interface SocieteAdminService extends  IService<Societe,SocieteCriteria, SocieteHistoryCriteria>  {

    List<Societe> findByAbonneId(Long id);
    int deleteByAbonneId(Long id);

    HttpEntity<byte[]> createPdf(SocieteDto dto) throws Exception;


}
