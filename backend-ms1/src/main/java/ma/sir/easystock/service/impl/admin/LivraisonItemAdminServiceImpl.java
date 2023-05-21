package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.LivraisonItem;
import ma.sir.easystock.bean.history.LivraisonItemHistory;
import ma.sir.easystock.dao.criteria.core.LivraisonItemCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.LivraisonItemDao;
import ma.sir.easystock.dao.facade.history.LivraisonItemHistoryDao;
import ma.sir.easystock.dao.specification.core.LivraisonItemSpecification;
import ma.sir.easystock.service.facade.admin.LivraisonItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.LivraisonItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.LivraisonAdminService ;
import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.MagasinAdminService ;


import java.util.List;
@Service
public class LivraisonItemAdminServiceImpl extends AbstractServiceImpl<LivraisonItem,LivraisonItemHistory, LivraisonItemCriteria, LivraisonItemHistoryCriteria, LivraisonItemDao,
LivraisonItemHistoryDao> implements LivraisonItemAdminService {
    public static final String TEMPLATE = "template/livraisonItem.vm";
    public static final String FILE_NAME = "livraisonItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(LivraisonItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<LivraisonItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<LivraisonItem> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public List<LivraisonItem> findByLivraisonId(Long id){
        return dao.findByLivraisonId(id);
    }
    public int deleteByLivraisonId(Long id){
        return dao.deleteByLivraisonId(id);
    }



    public void configure() {
        super.configure(LivraisonItem.class,LivraisonItemHistory.class, LivraisonItemHistoryCriteria.class, LivraisonItemSpecification.class);
    }

    @Autowired
    private LivraisonAdminService livraisonService ;
    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public LivraisonItemAdminServiceImpl(LivraisonItemDao dao, LivraisonItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}