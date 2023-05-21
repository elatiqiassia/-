package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ComptableValidateur;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;
import ma.sir.easystock.dao.criteria.core.ComptableValidateurCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableValidateurHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ComptableValidateurDao;
import ma.sir.easystock.dao.facade.history.ComptableValidateurHistoryDao;
import ma.sir.easystock.dao.specification.core.ComptableValidateurSpecification;
import ma.sir.easystock.service.facade.admin.ComptableValidateurAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ComptableValidateurDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ComptableValidateurAdminServiceImpl extends AbstractServiceImpl<ComptableValidateur,ComptableValidateurHistory, ComptableValidateurCriteria, ComptableValidateurHistoryCriteria, ComptableValidateurDao,
ComptableValidateurHistoryDao> implements ComptableValidateurAdminService {
    public static final String TEMPLATE = "template/comptableValidateur.vm";
    public static final String FILE_NAME = "comptableValidateur.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ComptableValidateurDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ComptableValidateur findByReferenceEntity(ComptableValidateur t){
        return  dao.findByCin(t.getCin());
    }




    public void configure() {
        super.configure(ComptableValidateur.class,ComptableValidateurHistory.class, ComptableValidateurHistoryCriteria.class, ComptableValidateurSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ComptableValidateurAdminServiceImpl(ComptableValidateurDao dao, ComptableValidateurHistoryDao historyDao) {
        super(dao, historyDao);
    }

}