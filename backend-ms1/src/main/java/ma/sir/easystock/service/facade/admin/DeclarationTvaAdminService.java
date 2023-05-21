package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.DeclarationTva;
import ma.sir.easystock.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.easystock.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.DeclarationTvaDto;
import org.springframework.http.HttpEntity;

public interface DeclarationTvaAdminService extends  IService<DeclarationTva,DeclarationTvaCriteria, DeclarationTvaHistoryCriteria>  {

    List<DeclarationTva> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTauxRetardTvaId(Long id);
    int deleteByTauxRetardTvaId(Long id);
    List<DeclarationTva> findByComptableTraitantId(Long id);
    int deleteByComptableTraitantId(Long id);
    List<DeclarationTva> findByComptableValidateurId(Long id);
    int deleteByComptableValidateurId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationTvaDto dto) throws Exception;


}
