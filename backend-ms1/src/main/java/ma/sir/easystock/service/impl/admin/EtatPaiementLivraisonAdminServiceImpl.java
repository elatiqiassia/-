package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementLivraison;
import ma.sir.easystock.bean.history.EtatPaiementLivraisonHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementLivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementLivraisonHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementLivraisonDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementLivraisonHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementLivraisonSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementLivraisonAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatPaiementLivraisonDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatPaiementLivraisonAdminServiceImpl extends AbstractServiceImpl<EtatPaiementLivraison,EtatPaiementLivraisonHistory, EtatPaiementLivraisonCriteria, EtatPaiementLivraisonHistoryCriteria, EtatPaiementLivraisonDao,
EtatPaiementLivraisonHistoryDao> implements EtatPaiementLivraisonAdminService {
    public static final String TEMPLATE = "template/etatPaiementLivraison.vm";
    public static final String FILE_NAME = "etatPaiementLivraison.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatPaiementLivraisonDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatPaiementLivraison findByReferenceEntity(EtatPaiementLivraison t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatPaiementLivraison.class,EtatPaiementLivraisonHistory.class, EtatPaiementLivraisonHistoryCriteria.class, EtatPaiementLivraisonSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatPaiementLivraisonAdminServiceImpl(EtatPaiementLivraisonDao dao, EtatPaiementLivraisonHistoryDao historyDao) {
        super(dao, historyDao);
    }

}