package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.TauxRetardTva;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;
import ma.sir.easystock.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.easystock.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.easystock.dao.facade.core.TauxRetardTvaDao;
import ma.sir.easystock.dao.facade.history.TauxRetardTvaHistoryDao;
import ma.sir.easystock.dao.specification.core.TauxRetardTvaSpecification;
import ma.sir.easystock.service.facade.admin.TauxRetardTvaAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TauxRetardTvaAdminServiceImpl extends AbstractServiceImpl<TauxRetardTva,TauxRetardTvaHistory, TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria, TauxRetardTvaDao,
TauxRetardTvaHistoryDao> implements TauxRetardTvaAdminService {
    public static final String TEMPLATE = "template/tauxRetardTva.vm";
    public static final String FILE_NAME = "tauxRetardTva.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(TauxRetardTva.class,TauxRetardTvaHistory.class, TauxRetardTvaHistoryCriteria.class, TauxRetardTvaSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TauxRetardTvaAdminServiceImpl(TauxRetardTvaDao dao, TauxRetardTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}