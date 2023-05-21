package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementDemande;
import ma.sir.easystock.bean.history.EtatPaiementDemandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementDemandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementDemandeDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementDemandeHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementDemandeSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementDemandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatPaiementDemandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatPaiementDemandeAdminServiceImpl extends AbstractServiceImpl<EtatPaiementDemande,EtatPaiementDemandeHistory, EtatPaiementDemandeCriteria, EtatPaiementDemandeHistoryCriteria, EtatPaiementDemandeDao,
EtatPaiementDemandeHistoryDao> implements EtatPaiementDemandeAdminService {
    public static final String TEMPLATE = "template/etatPaiementDemande.vm";
    public static final String FILE_NAME = "etatPaiementDemande.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatPaiementDemandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatPaiementDemande findByReferenceEntity(EtatPaiementDemande t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatPaiementDemande.class,EtatPaiementDemandeHistory.class, EtatPaiementDemandeHistoryCriteria.class, EtatPaiementDemandeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatPaiementDemandeAdminServiceImpl(EtatPaiementDemandeDao dao, EtatPaiementDemandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}