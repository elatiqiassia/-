package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.DeclarationIs;
import ma.sir.easystock.bean.history.DeclarationIsHistory;
import ma.sir.easystock.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.easystock.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DeclarationIsDao;
import ma.sir.easystock.dao.facade.history.DeclarationIsHistoryDao;
import ma.sir.easystock.dao.specification.core.DeclarationIsSpecification;
import ma.sir.easystock.service.facade.admin.DeclarationIsAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.SocieteAdminService ;
import ma.sir.easystock.service.facade.admin.TauxIsAdminService ;
import ma.sir.easystock.service.facade.admin.ComptableTraitantAdminService ;
import ma.sir.easystock.service.facade.admin.ComptableValidateurAdminService ;


import java.util.List;
@Service
public class DeclarationIsAdminServiceImpl extends AbstractServiceImpl<DeclarationIs,DeclarationIsHistory, DeclarationIsCriteria, DeclarationIsHistoryCriteria, DeclarationIsDao,
DeclarationIsHistoryDao> implements DeclarationIsAdminService {
    public static final String TEMPLATE = "template/declarationIs.vm";
    public static final String FILE_NAME = "declarationIs.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public DeclarationIs findByReferenceEntity(DeclarationIs t){
        return  dao.findByReference(t.getReference());
    }

    public List<DeclarationIs> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationIs> findByTauxIsId(Long id){
        return dao.findByTauxIsId(id);
    }
    public int deleteByTauxIsId(Long id){
        return dao.deleteByTauxIsId(id);
    }
    public List<DeclarationIs> findByComptableTraitantId(Long id){
        return dao.findByComptableTraitantId(id);
    }
    public int deleteByComptableTraitantId(Long id){
        return dao.deleteByComptableTraitantId(id);
    }
    public List<DeclarationIs> findByComptableValidateurId(Long id){
        return dao.findByComptableValidateurId(id);
    }
    public int deleteByComptableValidateurId(Long id){
        return dao.deleteByComptableValidateurId(id);
    }



    public void configure() {
        super.configure(DeclarationIs.class,DeclarationIsHistory.class, DeclarationIsHistoryCriteria.class, DeclarationIsSpecification.class);
    }

    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private TauxIsAdminService tauxIsService ;
    @Autowired
    private ComptableTraitantAdminService comptableTraitantService ;
    @Autowired
    private ComptableValidateurAdminService comptableValidateurService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeclarationIsAdminServiceImpl(DeclarationIsDao dao, DeclarationIsHistoryDao historyDao) {
        super(dao, historyDao);
    }

}