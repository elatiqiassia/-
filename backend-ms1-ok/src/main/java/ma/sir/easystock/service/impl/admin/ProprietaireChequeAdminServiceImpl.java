package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ProprietaireCheque;
import ma.sir.easystock.bean.history.ProprietaireChequeHistory;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ProprietaireChequeDao;
import ma.sir.easystock.dao.facade.history.ProprietaireChequeHistoryDao;
import ma.sir.easystock.dao.specification.core.ProprietaireChequeSpecification;
import ma.sir.easystock.service.facade.admin.ProprietaireChequeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ProprietaireChequeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ProprietaireChequeAdminServiceImpl extends AbstractServiceImpl<ProprietaireCheque,ProprietaireChequeHistory, ProprietaireChequeCriteria, ProprietaireChequeHistoryCriteria, ProprietaireChequeDao,
ProprietaireChequeHistoryDao> implements ProprietaireChequeAdminService {
    public static final String TEMPLATE = "template/proprietaireCheque.vm";
    public static final String FILE_NAME = "proprietaireCheque.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ProprietaireChequeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(ProprietaireCheque.class,ProprietaireChequeHistory.class, ProprietaireChequeHistoryCriteria.class, ProprietaireChequeSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ProprietaireChequeAdminServiceImpl(ProprietaireChequeDao dao, ProprietaireChequeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}