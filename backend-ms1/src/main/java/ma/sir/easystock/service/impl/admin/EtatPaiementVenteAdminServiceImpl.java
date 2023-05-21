package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.EtatPaiementVente;
import ma.sir.easystock.bean.history.EtatPaiementVenteHistory;
import ma.sir.easystock.dao.criteria.core.EtatPaiementVenteCriteria;
import ma.sir.easystock.dao.criteria.history.EtatPaiementVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.EtatPaiementVenteDao;
import ma.sir.easystock.dao.facade.history.EtatPaiementVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.EtatPaiementVenteSpecification;
import ma.sir.easystock.service.facade.admin.EtatPaiementVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.EtatPaiementVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatPaiementVenteAdminServiceImpl extends AbstractServiceImpl<EtatPaiementVente,EtatPaiementVenteHistory, EtatPaiementVenteCriteria, EtatPaiementVenteHistoryCriteria, EtatPaiementVenteDao,
EtatPaiementVenteHistoryDao> implements EtatPaiementVenteAdminService {
    public static final String TEMPLATE = "template/etatPaiementVente.vm";
    public static final String FILE_NAME = "etatPaiementVente.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatPaiementVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public EtatPaiementVente findByReferenceEntity(EtatPaiementVente t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(EtatPaiementVente.class,EtatPaiementVenteHistory.class, EtatPaiementVenteHistoryCriteria.class, EtatPaiementVenteSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatPaiementVenteAdminServiceImpl(EtatPaiementVenteDao dao, EtatPaiementVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}