package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Fournisseur;
import ma.sir.easystock.bean.history.FournisseurHistory;
import ma.sir.easystock.dao.criteria.core.FournisseurCriteria;
import ma.sir.easystock.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.easystock.dao.facade.core.FournisseurDao;
import ma.sir.easystock.dao.facade.history.FournisseurHistoryDao;
import ma.sir.easystock.dao.specification.core.FournisseurSpecification;
import ma.sir.easystock.service.facade.admin.FournisseurAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.FournisseurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class FournisseurAdminServiceImpl extends AbstractServiceImpl<Fournisseur,FournisseurHistory, FournisseurCriteria, FournisseurHistoryCriteria, FournisseurDao,
FournisseurHistoryDao> implements FournisseurAdminService {
    public static final String TEMPLATE = "template/fournisseur.vm";
    public static final String FILE_NAME = "fournisseur.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(FournisseurDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Fournisseur findByReferenceEntity(Fournisseur t){
        return  dao.findByIce(t.getIce());
    }




    public void configure() {
        super.configure(Fournisseur.class,FournisseurHistory.class, FournisseurHistoryCriteria.class, FournisseurSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public FournisseurAdminServiceImpl(FournisseurDao dao, FournisseurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}