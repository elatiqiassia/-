package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Livraison;
import ma.sir.easystock.bean.history.LivraisonHistory;
import ma.sir.easystock.dao.criteria.core.LivraisonCriteria;
import ma.sir.easystock.dao.criteria.history.LivraisonHistoryCriteria;
import ma.sir.easystock.dao.facade.core.LivraisonDao;
import ma.sir.easystock.dao.facade.history.LivraisonHistoryDao;
import ma.sir.easystock.dao.specification.core.LivraisonSpecification;
import ma.sir.easystock.service.facade.admin.LivraisonAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.LivraisonDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.LivraisonItem;

import ma.sir.easystock.service.facade.admin.DemandeAdminService ;
import ma.sir.easystock.service.facade.admin.ClientAdminService ;
import ma.sir.easystock.service.facade.admin.EtatLivraisonAdminService ;
import ma.sir.easystock.service.facade.admin.LivraisonItemAdminService ;


import java.util.List;
@Service
public class LivraisonAdminServiceImpl extends AbstractServiceImpl<Livraison,LivraisonHistory, LivraisonCriteria, LivraisonHistoryCriteria, LivraisonDao,
LivraisonHistoryDao> implements LivraisonAdminService {
    public static final String TEMPLATE = "template/livraison.vm";
    public static final String FILE_NAME = "livraison.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(LivraisonDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Livraison create(Livraison t) {
        super.create(t);
        if (t.getLivraisonItems() != null) {
                t.getLivraisonItems().forEach(element-> {
                    element.setLivraison(t);
                    livraisonItemService.create(element);
            });
        }
        return t;
    }

    public Livraison findWithAssociatedLists(Long id){
        Livraison result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setLivraisonItems(livraisonItemService.findByLivraisonId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        livraisonItemService.deleteByLivraisonId(id);
    }


    public void updateWithAssociatedLists(Livraison livraison){
    if(livraison !=null && livraison.getId() != null){
            List<List<LivraisonItem>> resultLivraisonItems= livraisonItemService.getToBeSavedAndToBeDeleted(livraisonItemService.findByLivraisonId(livraison.getId()),livraison.getLivraisonItems());
            livraisonItemService.delete(resultLivraisonItems.get(1));
            ListUtil.emptyIfNull(resultLivraisonItems.get(0)).forEach(e -> e.setLivraison(livraison));
            livraisonItemService.update(resultLivraisonItems.get(0),true);
    }
    }


    public List<Livraison> findByDemandeId(Long id){
        return dao.findByDemandeId(id);
    }
    public int deleteByDemandeId(Long id){
        return dao.deleteByDemandeId(id);
    }
    public List<Livraison> findByEtatLivraisonId(Long id){
        return dao.findByEtatLivraisonId(id);
    }
    public int deleteByEtatLivraisonId(Long id){
        return dao.deleteByEtatLivraisonId(id);
    }
    public List<Livraison> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }



    public void configure() {
        super.configure(Livraison.class,LivraisonHistory.class, LivraisonHistoryCriteria.class, LivraisonSpecification.class);
    }

    @Autowired
    private DemandeAdminService demandeService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private EtatLivraisonAdminService etatLivraisonService ;
    @Autowired
    private LivraisonItemAdminService livraisonItemService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public LivraisonAdminServiceImpl(LivraisonDao dao, LivraisonHistoryDao historyDao) {
        super(dao, historyDao);
    }

}