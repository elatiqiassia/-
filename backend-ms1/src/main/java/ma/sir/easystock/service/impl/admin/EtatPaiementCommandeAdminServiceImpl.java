package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementCommande;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementCommandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementCommandeDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementCommandeHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementCommandeSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementCommandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatPaiementCommandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatPaiementCommandeAdminServiceImpl extends AbstractServiceImpl<EtatPaiementCommande,EtatPaiementCommandeHistory, EtatPaiementCommandeCriteria, EtatPaiementCommandeHistoryCriteria, EtatPaiementCommandeDao,
EtatPaiementCommandeHistoryDao> implements EtatPaiementCommandeAdminService {
    public static final String TEMPLATE = "template/etatPaiementCommande.vm";
    public static final String FILE_NAME = "etatPaiementCommande.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatPaiementCommandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatPaiementCommande findByReferenceEntity(EtatPaiementCommande t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatPaiementCommande.class,EtatPaiementCommandeHistory.class, EtatPaiementCommandeHistoryCriteria.class, EtatPaiementCommandeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatPaiementCommandeAdminServiceImpl(EtatPaiementCommandeDao dao, EtatPaiementCommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}