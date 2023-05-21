package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatAvoirVente;
import ma.sir.easystock.bean.history.EtatAvoirVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatAvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatAvoirVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatAvoirVenteDao;
import ma.sir.easystock.dao.facade.history.EtatAvoirVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatAvoirVenteSpecification;
import ma.sir.easystock.service.facade.admin.EtatAvoirVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatAvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatAvoirVenteAdminServiceImpl extends AbstractServiceImpl<EtatAvoirVente,EtatAvoirVenteHistory, EtatAvoirVenteCriteria, EtatAvoirVenteHistoryCriteria, EtatAvoirVenteDao,
EtatAvoirVenteHistoryDao> implements EtatAvoirVenteAdminService {
    public static final String TEMPLATE = "template/etatAvoirVente.vm";
    public static final String FILE_NAME = "etatAvoirVente.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatAvoirVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatAvoirVente findByReferenceEntity(EtatAvoirVente t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatAvoirVente.class,EtatAvoirVenteHistory.class, EtatAvoirVenteHistoryCriteria.class, EtatAvoirVenteSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatAvoirVenteAdminServiceImpl(EtatAvoirVenteDao dao, EtatAvoirVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}