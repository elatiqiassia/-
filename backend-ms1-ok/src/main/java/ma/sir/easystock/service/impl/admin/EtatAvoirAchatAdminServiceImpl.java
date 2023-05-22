package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatAvoirAchat;
import ma.sir.easystock.bean.history.EtatAvoirAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatAvoirAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirAchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatAvoirAchatDao;
import ma.sir.easystock.dao.facade.history.EtatAvoirAchatHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatAvoirAchatSpecification;
import ma.sir.easystock.service.facade.admin.EtatAvoirAchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatAvoirAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatAvoirAchatAdminServiceImpl extends AbstractServiceImpl<EtatAvoirAchat,EtatAvoirAchatHistory, EtatAvoirAchatCriteria, EtatAvoirAchatHistoryCriteria, EtatAvoirAchatDao,
EtatAvoirAchatHistoryDao> implements EtatAvoirAchatAdminService {
    public static final String TEMPLATE = "template/etatAvoirAchat.vm";
    public static final String FILE_NAME = "etatAvoirAchat.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatAvoirAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatAvoirAchat findByReferenceEntity(EtatAvoirAchat t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatAvoirAchat.class,EtatAvoirAchatHistory.class, EtatAvoirAchatHistoryCriteria.class, EtatAvoirAchatSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAvoirAchatAdminServiceImpl(EtatAvoirAchatDao dao, EtatAvoirAchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}