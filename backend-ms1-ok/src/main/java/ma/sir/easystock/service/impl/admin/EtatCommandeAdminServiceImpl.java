package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatCommande;
import ma.sir.easystock.bean.history.EtatCommandeHistory;
import ma.sir.easystock.dao.criteria.core.EtatCommandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatCommandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatCommandeDao;
import ma.sir.easystock.dao.facade.history.EtatCommandeHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatCommandeSpecification;
import ma.sir.easystock.service.facade.admin.EtatCommandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatCommandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatCommandeAdminServiceImpl extends AbstractServiceImpl<EtatCommande,EtatCommandeHistory, EtatCommandeCriteria, EtatCommandeHistoryCriteria, EtatCommandeDao,
EtatCommandeHistoryDao> implements EtatCommandeAdminService {
    public static final String TEMPLATE = "template/etatCommande.vm";
    public static final String FILE_NAME = "etatCommande.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatCommandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatCommande findByReferenceEntity(EtatCommande t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatCommande.class,EtatCommandeHistory.class, EtatCommandeHistoryCriteria.class, EtatCommandeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatCommandeAdminServiceImpl(EtatCommandeDao dao, EtatCommandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}