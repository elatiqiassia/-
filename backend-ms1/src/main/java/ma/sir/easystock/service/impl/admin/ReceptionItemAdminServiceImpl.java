package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.ReceptionItem;
import ma.sir.easystock.bean.history.ReceptionItemHistory;
import ma.sir.easystock.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.easystock.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ReceptionItemDao;
import ma.sir.easystock.dao.facade.history.ReceptionItemHistoryDao;
import ma.sir.easystock.dao.specification.core.ReceptionItemSpecification;
import ma.sir.easystock.service.facade.admin.ReceptionItemAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ReceptionItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.ProduitAdminService ;
import ma.sir.easystock.service.facade.admin.ReceptionAdminService ;
import ma.sir.easystock.service.facade.admin.MagasinAdminService ;


import java.util.List;
@Service
public class ReceptionItemAdminServiceImpl extends AbstractServiceImpl<ReceptionItem,ReceptionItemHistory, ReceptionItemCriteria, ReceptionItemHistoryCriteria, ReceptionItemDao,
ReceptionItemHistoryDao> implements ReceptionItemAdminService {
    public static final String TEMPLATE = "template/receptionItem.vm";
    public static final String FILE_NAME = "receptionItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReceptionItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<ReceptionItem> findByProduitId(Long id){
        return dao.findByProduitId(id);
    }
    public int deleteByProduitId(Long id){
        return dao.deleteByProduitId(id);
    }
    public List<ReceptionItem> findByMagasinId(Long id){
        return dao.findByMagasinId(id);
    }
    public int deleteByMagasinId(Long id){
        return dao.deleteByMagasinId(id);
    }
    public List<ReceptionItem> findByReceptionId(Long id){
        return dao.findByReceptionId(id);
    }
    public int deleteByReceptionId(Long id){
        return dao.deleteByReceptionId(id);
    }



    public void configure() {
        super.configure(ReceptionItem.class,ReceptionItemHistory.class, ReceptionItemHistoryCriteria.class, ReceptionItemSpecification.class);
    }

    @Autowired
    private ProduitAdminService produitService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private MagasinAdminService magasinService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReceptionItemAdminServiceImpl(ReceptionItemDao dao, ReceptionItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}