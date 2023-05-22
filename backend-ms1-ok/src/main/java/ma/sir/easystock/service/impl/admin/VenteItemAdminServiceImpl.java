package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.VenteItem;
import ma.sir.easystock.bean.history.VenteItemHistory;
import ma.sir.easystock.dao.criteria.core.VenteItemCriteria;
import ma.sir.easystock.dao.criteria.history.VenteItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.VenteItemDao;
import ma.sir.easystock.dao.facade.history.VenteItemHistoryDao;
import ma.sir.easystock.dao.specification.core.VenteItemSpecification;
import ma.sir.easystock.service.facade.admin.VenteItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.VenteItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.VenteAdminService ;


import java.util.List;
@Service
public class VenteItemAdminServiceImpl extends AbstractServiceImpl<VenteItem,VenteItemHistory, VenteItemCriteria, VenteItemHistoryCriteria, VenteItemDao,
VenteItemHistoryDao> implements VenteItemAdminService {
    public static final String TEMPLATE = "template/venteItem.vm";
    public static final String FILE_NAME = "venteItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(VenteItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<VenteItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<VenteItem> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }



    public void configure() {
        super.configure(VenteItem.class,VenteItemHistory.class, VenteItemHistoryCriteria.class, VenteItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public VenteItemAdminServiceImpl(VenteItemDao dao, VenteItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}