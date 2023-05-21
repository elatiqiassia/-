package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Marque;
import ma.sir.easystock.bean.history.MarqueHistory;
import ma.sir.easystock.dao.criteria.core.MarqueCriteria;
import ma.sir.easystock.dao.criteria.history.MarqueHistoryCriteria;
import ma.sir.easystock.dao.facade.core.MarqueDao;
import ma.sir.easystock.dao.facade.history.MarqueHistoryDao;
import ma.sir.easystock.dao.specification.core.MarqueSpecification;
import ma.sir.easystock.service.facade.admin.MarqueAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.MarqueDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class MarqueAdminServiceImpl extends AbstractServiceImpl<Marque,MarqueHistory, MarqueCriteria, MarqueHistoryCriteria, MarqueDao,
MarqueHistoryDao> implements MarqueAdminService {
    public static final String TEMPLATE = "template/marque.vm";
    public static final String FILE_NAME = "marque.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(MarqueDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Marque findByReferenceEntity(Marque t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(Marque.class,MarqueHistory.class, MarqueHistoryCriteria.class, MarqueSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public MarqueAdminServiceImpl(MarqueDao dao, MarqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}