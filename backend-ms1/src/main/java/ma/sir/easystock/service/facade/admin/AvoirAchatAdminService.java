package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.AvoirAchat;
import ma.sir.easystock.dao.criteria.core.AvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirAchatHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.AvoirAchatDto;
import org.springframework.http.HttpEntity;

public interface AvoirAchatAdminService extends  IService<AvoirAchat,AvoirAchatCriteria, AvoirAchatHistoryCriteria>  {

    List<AvoirAchat> findByAchatId(Long id);
    int deleteByAchatId(Long id);
    List<AvoirAchat> findByEtatAvoirAchatId(Long id);
    int deleteByEtatAvoirAchatId(Long id);

    HttpEntity<byte[]> createPdf(AvoirAchatDto dto) throws Exception;


}
