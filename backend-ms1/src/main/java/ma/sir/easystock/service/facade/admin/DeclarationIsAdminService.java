package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.DeclarationIs;
import ma.sir.easystock.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.easystock.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

public interface DeclarationIsAdminService extends  IService<DeclarationIs,DeclarationIsCriteria, DeclarationIsHistoryCriteria>  {

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);
    List<DeclarationIs> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    List<DeclarationIs> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception;


}
