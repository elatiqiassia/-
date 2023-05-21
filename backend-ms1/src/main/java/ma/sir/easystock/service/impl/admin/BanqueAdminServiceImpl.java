package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Banque;
import ma.sir.easystock.bean.history.BanqueHistory;
import ma.sir.easystock.dao.criteria.core.BanqueCriteria;
import ma.sir.easystock.dao.criteria.history.BanqueHistoryCriteria;
import ma.sir.easystock.dao.facade.core.BanqueDao;
import ma.sir.easystock.dao.facade.history.BanqueHistoryDao;
import ma.sir.easystock.dao.specification.core.BanqueSpecification;
import ma.sir.easystock.service.facade.admin.BanqueAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.BanqueDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class BanqueAdminServiceImpl extends AbstractServiceImpl<Banque,BanqueHistory, BanqueCriteria, BanqueHistoryCriteria, BanqueDao,
BanqueHistoryDao> implements BanqueAdminService {
    public static final String TEMPLATE = "template/banque.vm";
    public static final String FILE_NAME = "banque.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BanqueDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(Banque.class,BanqueHistory.class, BanqueHistoryCriteria.class, BanqueSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public BanqueAdminServiceImpl(BanqueDao dao, BanqueHistoryDao historyDao) {
        super(dao, historyDao);
    }

}