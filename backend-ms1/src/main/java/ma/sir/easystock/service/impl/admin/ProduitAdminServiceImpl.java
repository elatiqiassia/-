package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Produit;
import ma.sir.easystock.bean.history.ProduitHistory;
import ma.sir.easystock.dao.criteria.core.ProduitCriteria;
import ma.sir.easystock.dao.criteria.history.ProduitHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ProduitDao;
import ma.sir.easystock.dao.facade.history.ProduitHistoryDao;
import ma.sir.easystock.dao.specification.core.ProduitSpecification;
import ma.sir.easystock.service.facade.admin.ProduitAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ProduitDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.StoreAdminService ;
import ma.sir.easystock.service.facade.admin.CategorieProduitAdminService ;
import ma.sir.easystock.service.facade.admin.UniteMesureAdminService ;
import ma.sir.easystock.service.facade.admin.MarqueAdminService ;


import java.util.List;
@Service
public class ProduitAdminServiceImpl extends AbstractServiceImpl<Produit,ProduitHistory, ProduitCriteria, ProduitHistoryCriteria, ProduitDao,
ProduitHistoryDao> implements ProduitAdminService {
    public static final String TEMPLATE = "template/produit.vm";
    public static final String FILE_NAME = "produit.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ProduitDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Produit findByReferenceEntity(Produit t){
        return  dao.findByReference(t.getReference());
    }

    public List<Produit> findByCategorieProduitId(Long id){
        return dao.findByCategorieProduitId(id);
    }
    public int deleteByCategorieProduitId(Long id){
        return dao.deleteByCategorieProduitId(id);
    }
    public List<Produit> findByUniteMesureId(Long id){
        return dao.findByUniteMesureId(id);
    }
    public int deleteByUniteMesureId(Long id){
        return dao.deleteByUniteMesureId(id);
    }
    public List<Produit> findByMarqueId(Long id){
        return dao.findByMarqueId(id);
    }
    public int deleteByMarqueId(Long id){
        return dao.deleteByMarqueId(id);
    }
    public List<Produit> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }



    public void configure() {
        super.configure(Produit.class,ProduitHistory.class, ProduitHistoryCriteria.class, ProduitSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private CategorieProduitAdminService categorieProduitService ;
    @Autowired
    private UniteMesureAdminService uniteMesureService ;
    @Autowired
    private MarqueAdminService marqueService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ProduitAdminServiceImpl(ProduitDao dao, ProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}