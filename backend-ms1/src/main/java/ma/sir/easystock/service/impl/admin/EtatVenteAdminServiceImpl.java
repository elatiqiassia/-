package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatVente;
import ma.sir.easystock.bean.history.EtatVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatVenteDao;
import ma.sir.easystock.dao.facade.history.EtatVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatVenteSpecification;
import ma.sir.easystock.service.facade.admin.EtatVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatVenteAdminServiceImpl extends AbstractServiceImpl<EtatVente,EtatVenteHistory, EtatVenteCriteria, EtatVenteHistoryCriteria, EtatVenteDao,
EtatVenteHistoryDao> implements EtatVenteAdminService {
    public static final String TEMPLATE = "template/etatVente.vm";
    public static final String FILE_NAME = "etatVente.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatVente findByReferenceEntity(EtatVente t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatVente.class,EtatVenteHistory.class, EtatVenteHistoryCriteria.class, EtatVenteSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatVenteAdminServiceImpl(EtatVenteDao dao, EtatVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}