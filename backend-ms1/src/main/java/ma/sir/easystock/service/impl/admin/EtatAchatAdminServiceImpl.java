package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatAchat;
import ma.sir.easystock.bean.history.EtatAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatAchatDao;
import ma.sir.easystock.dao.facade.history.EtatAchatHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatAchatSpecification;
import ma.sir.easystock.service.facade.admin.EtatAchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatAchatAdminServiceImpl extends AbstractServiceImpl<EtatAchat,EtatAchatHistory, EtatAchatCriteria, EtatAchatHistoryCriteria, EtatAchatDao,
EtatAchatHistoryDao> implements EtatAchatAdminService {
    public static final String TEMPLATE = "template/etatAchat.vm";
    public static final String FILE_NAME = "etatAchat.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatAchat findByReferenceEntity(EtatAchat t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatAchat.class,EtatAchatHistory.class, EtatAchatHistoryCriteria.class, EtatAchatSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAchatAdminServiceImpl(EtatAchatDao dao, EtatAchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}