package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatDemande;
import ma.sir.easystock.bean.history.EtatDemandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatDemandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatDemandeDao;
import ma.sir.easystock.dao.facade.history.EtatDemandeHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatDemandeSpecification;
import ma.sir.easystock.service.facade.admin.EtatDemandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatDemandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatDemandeAdminServiceImpl extends AbstractServiceImpl<EtatDemande,EtatDemandeHistory, EtatDemandeCriteria, EtatDemandeHistoryCriteria, EtatDemandeDao,
EtatDemandeHistoryDao> implements EtatDemandeAdminService {
    public static final String TEMPLATE = "template/etatDemande.vm";
    public static final String FILE_NAME = "etatDemande.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatDemandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatDemande findByReferenceEntity(EtatDemande t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatDemande.class,EtatDemandeHistory.class, EtatDemandeHistoryCriteria.class, EtatDemandeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatDemandeAdminServiceImpl(EtatDemandeDao dao, EtatDemandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}