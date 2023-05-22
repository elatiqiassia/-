package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ModePaiement;
import ma.sir.easystock.bean.history.ModePaiementHistory;
import ma.sir.easystock.dao.criteria.core.ModePaiementCriteria;
import ma.sir.easystock.dao.criteria.history.ModePaiementHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ModePaiementDao;
import ma.sir.easystock.dao.facade.history.ModePaiementHistoryDao;
import ma.sir.easystock.dao.specification.core.ModePaiementSpecification;
import ma.sir.easystock.service.facade.admin.ModePaiementAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ModePaiementDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ModePaiementAdminServiceImpl extends AbstractServiceImpl<ModePaiement,ModePaiementHistory, ModePaiementCriteria, ModePaiementHistoryCriteria, ModePaiementDao,
ModePaiementHistoryDao> implements ModePaiementAdminService {
    public static final String TEMPLATE = "template/modePaiement.vm";
    public static final String FILE_NAME = "modePaiement.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ModePaiementDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ModePaiement findByReferenceEntity(ModePaiement t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(ModePaiement.class,ModePaiementHistory.class, ModePaiementHistoryCriteria.class, ModePaiementSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ModePaiementAdminServiceImpl(ModePaiementDao dao, ModePaiementHistoryDao historyDao) {
        super(dao, historyDao);
    }

}