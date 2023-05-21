package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ClassComptable;
import ma.sir.easystock.bean.history.ClassComptableHistory;
import ma.sir.easystock.dao.criteria.core.ClassComptableCriteria;
import ma.sir.easystock.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ClassComptableDao;
import ma.sir.easystock.dao.facade.history.ClassComptableHistoryDao;
import ma.sir.easystock.dao.specification.core.ClassComptableSpecification;
import ma.sir.easystock.service.facade.admin.ClassComptableAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ClassComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ClassComptableAdminServiceImpl extends AbstractServiceImpl<ClassComptable,ClassComptableHistory, ClassComptableCriteria, ClassComptableHistoryCriteria, ClassComptableDao,
ClassComptableHistoryDao> implements ClassComptableAdminService {
    public static final String TEMPLATE = "template/classComptable.vm";
    public static final String FILE_NAME = "classComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ClassComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(ClassComptable.class,ClassComptableHistory.class, ClassComptableHistoryCriteria.class, ClassComptableSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ClassComptableAdminServiceImpl(ClassComptableDao dao, ClassComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}