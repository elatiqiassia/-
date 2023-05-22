package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ComptableTraitant;
import ma.sir.easystock.bean.history.ComptableTraitantHistory;
import ma.sir.easystock.dao.criteria.core.ComptableTraitantCriteria;
import ma.sir.easystock.dao.criteria.history.ComptableTraitantHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ComptableTraitantDao;
import ma.sir.easystock.dao.facade.history.ComptableTraitantHistoryDao;
import ma.sir.easystock.dao.specification.core.ComptableTraitantSpecification;
import ma.sir.easystock.service.facade.admin.ComptableTraitantAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ComptableTraitantDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ComptableTraitantAdminServiceImpl extends AbstractServiceImpl<ComptableTraitant,ComptableTraitantHistory, ComptableTraitantCriteria, ComptableTraitantHistoryCriteria, ComptableTraitantDao,
ComptableTraitantHistoryDao> implements ComptableTraitantAdminService {
    public static final String TEMPLATE = "template/comptableTraitant.vm";
    public static final String FILE_NAME = "comptableTraitant.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ComptableTraitantDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ComptableTraitant findByReferenceEntity(ComptableTraitant t){
        return  dao.findByCin(t.getCin());
    }




    public void configure() {
        super.configure(ComptableTraitant.class,ComptableTraitantHistory.class, ComptableTraitantHistoryCriteria.class, ComptableTraitantSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ComptableTraitantAdminServiceImpl(ComptableTraitantDao dao, ComptableTraitantHistoryDao historyDao) {
        super(dao, historyDao);
    }

}