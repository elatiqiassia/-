package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.StockProduit;
import ma.sir.easystock.bean.history.StockProduitHistory;
import ma.sir.easystock.dao.criteria.core.StockProduitCriteria;
import ma.sir.easystock.dao.criteria.history.StockProduitHistoryCriteria;
import ma.sir.easystock.dao.facade.core.StockProduitDao;
import ma.sir.easystock.dao.facade.history.StockProduitHistoryDao;
import ma.sir.easystock.dao.specification.core.StockProduitSpecification;
import ma.sir.easystock.service.facade.admin.StockProduitAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.StockProduitDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.MagasinAdminService ;
import ma.sir.easystock.service.facade.admin.ProduitAdminService ;


import java.util.List;
@Service
public class StockProduitAdminServiceImpl extends AbstractServiceImpl<StockProduit,StockProduitHistory, StockProduitCriteria, StockProduitHistoryCriteria, StockProduitDao,
StockProduitHistoryDao> implements StockProduitAdminService {
    public static final String TEMPLATE = "template/stockProduit.vm";
    public static final String FILE_NAME = "stockProduit.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(StockProduitDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<StockProduit> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public List<StockProduit> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }



    public void configure() {
        super.configure(StockProduit.class,StockProduitHistory.class, StockProduitHistoryCriteria.class, StockProduitSpecification.class);
    }

    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public StockProduitAdminServiceImpl(StockProduitDao dao, StockProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}