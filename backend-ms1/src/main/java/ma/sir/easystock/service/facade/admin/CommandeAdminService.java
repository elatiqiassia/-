package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.Commande;
import ma.sir.easystock.dao.criteria.core.CommandeCriteria;
import ma.sir.easystock.dao.criteria.history.CommandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.CommandeDto;
import org.springframework.http.HttpEntity;

public interface CommandeAdminService extends  IService<Commande,CommandeCriteria, CommandeHistoryCriteria>  {

    List<Commande> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Commande> findByEtatCommandeId(Long id);
    int deleteByEtatCommandeId(Long id);

    HttpEntity<byte[]> createPdf(CommandeDto dto) throws Exception;


}
