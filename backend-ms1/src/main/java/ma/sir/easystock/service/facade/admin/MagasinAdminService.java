package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Magasin;
import ma.sir.easystock.dao.criteria.core.MagasinCriteria;
import ma.sir.easystock.dao.criteria.history.MagasinHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.MagasinDto;
import org.springframework.http.HttpEntity;

public interface MagasinAdminService extends  IService<Magasin,MagasinCriteria, MagasinHistoryCriteria>  {

    List<Magasin> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    HttpEntity<byte[]> createPdf(MagasinDto dto) throws Exception;


}
