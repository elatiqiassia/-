package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Vente;
import ma.sir.easystock.bean.history.VenteHistory;
import ma.sir.easystock.dao.criteria.core.VenteCriteria;
import ma.sir.easystock.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.easystock.dao.facade.core.VenteDao;
import ma.sir.easystock.dao.facade.history.VenteHistoryDao;
import ma.sir.easystock.dao.specification.core.VenteSpecification;
import ma.sir.easystock.service.facade.admin.VenteAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.VenteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.VenteItem;

import ma.sir.easystock.service.facade.admin.EtatVenteAdminService ;
import ma.sir.easystock.service.facade.admin.StoreAdminService ;
import ma.sir.easystock.service.facade.admin.VenteItemAdminService ;
import ma.sir.easystock.service.facade.admin.ClientAdminService ;


import java.util.List;
@Service
public class VenteAdminServiceImpl extends AbstractServiceImpl<Vente,VenteHistory, VenteCriteria, VenteHistoryCriteria, VenteDao,
VenteHistoryDao> implements VenteAdminService {
    public static final String TEMPLATE = "template/vente.vm";
    public static final String FILE_NAME = "vente.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(VenteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Vente create(Vente t) {
        super.create(t);
        if (t.getVenteItems() != null) {
                t.getVenteItems().forEach(element-> {
                    element.setVente(t);
                    venteItemService.create(element);
            });
        }
        return t;
    }

    public Vente findWithAssociatedLists(Long id){
        Vente result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setVenteItems(venteItemService.findByVenteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        venteItemService.deleteByVenteId(id);
    }


    public void updateWithAssociatedLists(Vente vente){
    if(vente !=null && vente.getId() != null){
            List<List<VenteItem>> resultVenteItems= venteItemService.getToBeSavedAndToBeDeleted(venteItemService.findByVenteId(vente.getId()),vente.getVenteItems());
            venteItemService.delete(resultVenteItems.get(1));
            ListUtil.emptyIfNull(resultVenteItems.get(0)).forEach(e -> e.setVente(vente));
            venteItemService.update(resultVenteItems.get(0),true);
    }
    }

    public Vente findByReferenceEntity(Vente t){
        return  dao.findByReference(t.getReference());
    }

    public List<Vente> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<Vente> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Vente> findByEtatVenteId(Long id){
        return dao.findByEtatVenteId(id);
    }
    public int deleteByEtatVenteId(Long id){
        return dao.deleteByEtatVenteId(id);
    }



    public void configure() {
        super.configure(Vente.class,VenteHistory.class, VenteHistoryCriteria.class, VenteSpecification.class);
    }

    @Autowired
    private EtatVenteAdminService etatVenteService ;
    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private VenteItemAdminService venteItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public VenteAdminServiceImpl(VenteDao dao, VenteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}