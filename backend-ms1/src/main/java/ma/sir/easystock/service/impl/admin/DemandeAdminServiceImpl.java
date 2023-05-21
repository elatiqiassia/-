package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Demande;
import ma.sir.easystock.bean.history.DemandeHistory;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.dao.facade.core.DemandeDao;
import ma.sir.easystock.dao.facade.history.DemandeHistoryDao;
import ma.sir.easystock.dao.specification.core.DemandeSpecification;
import ma.sir.easystock.service.facade.admin.DemandeAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.DemandeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.DemandeItem;

import ma.sir.easystock.service.facade.admin.DemandeItemAdminService ;
import ma.sir.easystock.service.facade.admin.ClientAdminService ;
import ma.sir.easystock.service.facade.admin.EtatDemandeAdminService ;


import java.util.List;
@Service
public class DemandeAdminServiceImpl extends AbstractServiceImpl<Demande,DemandeHistory, DemandeCriteria, DemandeHistoryCriteria, DemandeDao,
DemandeHistoryDao> implements DemandeAdminService {
    public static final String TEMPLATE = "template/demande.vm";
    public static final String FILE_NAME = "demande.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DemandeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Demande create(Demande t) {
        super.create(t);
        if (t.getDemandeItems() != null) {
                t.getDemandeItems().forEach(element-> {
                    element.setDemande(t);
                    demandeItemService.create(element);
            });
        }
        return t;
    }

    public Demande findWithAssociatedLists(Long id){
        Demande result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDemandeItems(demandeItemService.findByDemandeId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        demandeItemService.deleteByDemandeId(id);
    }


    public void updateWithAssociatedLists(Demande demande){
    if(demande !=null && demande.getId() != null){
            List<List<DemandeItem>> resultDemandeItems= demandeItemService.getToBeSavedAndToBeDeleted(demandeItemService.findByDemandeId(demande.getId()),demande.getDemandeItems());
            demandeItemService.delete(resultDemandeItems.get(1));
            ListUtil.emptyIfNull(resultDemandeItems.get(0)).forEach(e -> e.setDemande(demande));
            demandeItemService.update(resultDemandeItems.get(0),true);
    }
    }

    public Demande findByReferenceEntity(Demande t){
        return  dao.findByReference(t.getReference());
    }

    public List<Demande> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Demande> findByEtatDemandeId(Long id){
        return dao.findByEtatDemandeId(id);
    }
    public int deleteByEtatDemandeId(Long id){
        return dao.deleteByEtatDemandeId(id);
    }



    public void configure() {
        super.configure(Demande.class,DemandeHistory.class, DemandeHistoryCriteria.class, DemandeSpecification.class);
    }

    @Autowired
    private DemandeItemAdminService demandeItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private EtatDemandeAdminService etatDemandeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DemandeAdminServiceImpl(DemandeDao dao, DemandeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}