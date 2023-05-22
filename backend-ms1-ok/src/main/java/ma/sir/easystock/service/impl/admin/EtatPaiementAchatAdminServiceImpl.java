package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementAchat;
import ma.sir.easystock.bean.history.EtatPaiementAchatHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementAchatCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementAchatHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementAchatDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementAchatHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementAchatSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementAchatAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatPaiementAchatDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatPaiementAchatAdminServiceImpl extends AbstractServiceImpl<EtatPaiementAchat,EtatPaiementAchatHistory, EtatPaiementAchatCriteria, EtatPaiementAchatHistoryCriteria, EtatPaiementAchatDao,
EtatPaiementAchatHistoryDao> implements EtatPaiementAchatAdminService {
    public static final String TEMPLATE = "template/etatPaiementAchat.vm";
    public static final String FILE_NAME = "etatPaiementAchat.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatPaiementAchatDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatPaiementAchat findByReferenceEntity(EtatPaiementAchat t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatPaiementAchat.class,EtatPaiementAchatHistory.class, EtatPaiementAchatHistoryCriteria.class, EtatPaiementAchatSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatPaiementAchatAdminServiceImpl(EtatPaiementAchatDao dao, EtatPaiementAchatHistoryDao historyDao) {
        super(dao, historyDao);
    }

}