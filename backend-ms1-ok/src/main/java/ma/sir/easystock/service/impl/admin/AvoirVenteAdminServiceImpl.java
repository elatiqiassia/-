package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.AvoirVente;
import ma.sir.easystock.bean.history.AvoirVenteHistory;
import ma.sir.easystock.dao.criteria.core.AvoirVenteCriteria;
import ma.sir.easystock.dao.criteria.history.AvoirVenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.AvoirVenteDao;
import ma.sir.easystock.dao.facade.history.AvoirVenteHistoryDao;
import ma.sir.easystock.dao.specification.core.AvoirVenteSpecification;
import ma.sir.easystock.service.facade.admin.AvoirVenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.AvoirVenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.AvoirVenteItem;

import ma.sir.easystock.service.facade.admin.AvoirVenteItemAdminService ;
import ma.sir.easystock.service.facade.admin.EtatAvoirVenteAdminService ;
import ma.sir.easystock.service.facade.admin.VenteAdminService ;


import java.util.List;
@Service
public class AvoirVenteAdminServiceImpl extends AbstractServiceImpl<AvoirVente,AvoirVenteHistory, AvoirVenteCriteria, AvoirVenteHistoryCriteria, AvoirVenteDao,
AvoirVenteHistoryDao> implements AvoirVenteAdminService {
    public static final String TEMPLATE = "template/avoirVente.vm";
    public static final String FILE_NAME = "avoirVente.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(AvoirVenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public AvoirVente create(AvoirVente t) {
        super.create(t);
        if (t.getAvoirVenteItems() != null) {
                t.getAvoirVenteItems().forEach(element-> {
                    element.setAvoirVente(t);
                    avoirVenteItemService.create(element);
            });
        }
        return t;
    }

    public AvoirVente findWithAssociatedLists(Long id){
        AvoirVente result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setAvoirVenteItems(avoirVenteItemService.findByAvoirVenteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        avoirVenteItemService.deleteByAvoirVenteId(id);
    }


    public void updateWithAssociatedLists(AvoirVente avoirVente){
    if(avoirVente !=null && avoirVente.getId() != null){
            List<List<AvoirVenteItem>> resultAvoirVenteItems= avoirVenteItemService.getToBeSavedAndToBeDeleted(avoirVenteItemService.findByAvoirVenteId(avoirVente.getId()),avoirVente.getAvoirVenteItems());
            avoirVenteItemService.delete(resultAvoirVenteItems.get(1));
            ListUtil.emptyIfNull(resultAvoirVenteItems.get(0)).forEach(e -> e.setAvoirVente(avoirVente));
            avoirVenteItemService.update(resultAvoirVenteItems.get(0),true);
    }
    }


    public List<AvoirVente> findByVenteId(Long id){
        return dao.findByVenteId(id);
    }
    public int deleteByVenteId(Long id){
        return dao.deleteByVenteId(id);
    }
    public List<AvoirVente> findByEtatAvoirVenteId(Long id){
        return dao.findByEtatAvoirVenteId(id);
    }
    public int deleteByEtatAvoirVenteId(Long id){
        return dao.deleteByEtatAvoirVenteId(id);
    }



    public void configure() {
        super.configure(AvoirVente.class,AvoirVenteHistory.class, AvoirVenteHistoryCriteria.class, AvoirVenteSpecification.class);
    }

    @Autowired
    private AvoirVenteItemAdminService avoirVenteItemService ;
    @Autowired
    private EtatAvoirVenteAdminService etatAvoirVenteService ;
    @Autowired
    private VenteAdminService venteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public AvoirVenteAdminServiceImpl(AvoirVenteDao dao, AvoirVenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}