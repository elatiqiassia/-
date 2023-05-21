package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatReception;
import ma.sir.easystock.bean.history.EtatReceptionHistory;
import ma.sir.easystock.dao.criteria.core.EtatReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.EtatReceptionHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatReceptionDao;
import ma.sir.easystock.dao.facade.history.EtatReceptionHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatReceptionSpecification;
import ma.sir.easystock.service.facade.admin.EtatReceptionAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatReceptionDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatReceptionAdminServiceImpl extends AbstractServiceImpl<EtatReception,EtatReceptionHistory, EtatReceptionCriteria, EtatReceptionHistoryCriteria, EtatReceptionDao,
EtatReceptionHistoryDao> implements EtatReceptionAdminService {
    public static final String TEMPLATE = "template/etatReception.vm";
    public static final String FILE_NAME = "etatReception.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatReceptionDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatReception findByReferenceEntity(EtatReception t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatReception.class,EtatReceptionHistory.class, EtatReceptionHistoryCriteria.class, EtatReceptionSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatReceptionAdminServiceImpl(EtatReceptionDao dao, EtatReceptionHistoryDao historyDao) {
        super(dao, historyDao);
    }

}