package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.DemandeItem;
import ma.sir.easystock.bean.history.DemandeItemHistory;
import ma.sir.easystock.dao.criteria.core.DemandeItemCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DemandeItemDao;
import ma.sir.easystock.dao.facade.history.DemandeItemHistoryDao;
import ma.sir.easystock.dao.specification.core.DemandeItemSpecification;
import ma.sir.easystock.service.facade.admin.DemandeItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.DemandeItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.DemandeAdminService ;


import java.util.List;
@Service
public class DemandeItemAdminServiceImpl extends AbstractServiceImpl<DemandeItem,DemandeItemHistory, DemandeItemCriteria, DemandeItemHistoryCriteria, DemandeItemDao,
DemandeItemHistoryDao> implements DemandeItemAdminService {
    public static final String TEMPLATE = "template/demandeItem.vm";
    public static final String FILE_NAME = "demandeItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandeItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<DemandeItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<DemandeItem> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }



    public void configure() {
        super.configure(DemandeItem.class,DemandeItemHistory.class, DemandeItemHistoryCriteria.class, DemandeItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DemandeItemAdminServiceImpl(DemandeItemDao dao, DemandeItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}