package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.CategorieProduit;
import ma.sir.easystock.bean.history.CategorieProduitHistory;
import ma.sir.easystock.dao.criteria.core.CategorieProduitCriteria;
import ma.sir.easystock.dao.criteria.history.CategorieProduitHistoryCriteria;
import ma.sir.easystock.dao.facade.core.CategorieProduitDao;
import ma.sir.easystock.dao.facade.history.CategorieProduitHistoryDao;
import ma.sir.easystock.dao.specification.core.CategorieProduitSpecification;
import ma.sir.easystock.service.facade.admin.CategorieProduitAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.CategorieProduitDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class CategorieProduitAdminServiceImpl extends AbstractServiceImpl<CategorieProduit,CategorieProduitHistory, CategorieProduitCriteria, CategorieProduitHistoryCriteria, CategorieProduitDao,
CategorieProduitHistoryDao> implements CategorieProduitAdminService {
    public static final String TEMPLATE = "template/categorieProduit.vm";
    public static final String FILE_NAME = "categorieProduit.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CategorieProduitDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public CategorieProduit findByReferenceEntity(CategorieProduit t){
        return  dao.findByReference(t.getReference());
    }




    public void configure() {
        super.configure(CategorieProduit.class,CategorieProduitHistory.class, CategorieProduitHistoryCriteria.class, CategorieProduitSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public CategorieProduitAdminServiceImpl(CategorieProduitDao dao, CategorieProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}