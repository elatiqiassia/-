package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Reception;
import ma.sir.easystock.bean.history.ReceptionHistory;
import ma.sir.easystock.dao.criteria.core.ReceptionCriteria;
import ma.sir.easystock.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.easystock.dao.facade.core.ReceptionDao;
import ma.sir.easystock.dao.facade.history.ReceptionHistoryDao;
import ma.sir.easystock.dao.specification.core.ReceptionSpecification;
import ma.sir.easystock.service.facade.admin.ReceptionAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.ReceptionDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.easystock.bean.core.ReceptionItem;

import ma.sir.easystock.service.facade.admin.CommandeAdminService ;
import ma.sir.easystock.service.facade.admin.ReceptionItemAdminService ;
import ma.sir.easystock.service.facade.admin.EtatReceptionAdminService ;


import java.util.List;
@Service
public class ReceptionAdminServiceImpl extends AbstractServiceImpl<Reception,ReceptionHistory, ReceptionCriteria, ReceptionHistoryCriteria, ReceptionDao,
ReceptionHistoryDao> implements ReceptionAdminService {
    public static final String TEMPLATE = "template/reception.vm";
    public static final String FILE_NAME = "reception.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReceptionDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Reception create(Reception t) {
        super.create(t);
        if (t.getReceptionItems() != null) {
                t.getReceptionItems().forEach(element-> {
                    element.setReception(t);
                    receptionItemService.create(element);
            });
        }
        return t;
    }

    public Reception findWithAssociatedLists(Long id){
        Reception result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReceptionItems(receptionItemService.findByReceptionId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        receptionItemService.deleteByReceptionId(id);
    }


    public void updateWithAssociatedLists(Reception reception){
    if(reception !=null && reception.getId() != null){
            List<List<ReceptionItem>> resultReceptionItems= receptionItemService.getToBeSavedAndToBeDeleted(receptionItemService.findByReceptionId(reception.getId()),reception.getReceptionItems());
            receptionItemService.delete(resultReceptionItems.get(1));
            ListUtil.emptyIfNull(resultReceptionItems.get(0)).forEach(e -> e.setReception(reception));
            receptionItemService.update(resultReceptionItems.get(0),true);
    }
    }

    public Reception findByReferenceEntity(Reception t){
        return  dao.findByReference(t.getReference());
    }

    public List<Reception> findByCommandeId(Long id){
        return dao.findByCommandeId(id);
    }
    public int deleteByCommandeId(Long id){
        return dao.deleteByCommandeId(id);
    }
    public List<Reception> findByEtatReceptionId(Long id){
        return dao.findByEtatReceptionId(id);
    }
    public int deleteByEtatReceptionId(Long id){
        return dao.deleteByEtatReceptionId(id);
    }



    public void configure() {
        super.configure(Reception.class,ReceptionHistory.class, ReceptionHistoryCriteria.class, ReceptionSpecification.class);
    }

    @Autowired
    private CommandeAdminService commandeService ;
    @Autowired
    private ReceptionItemAdminService receptionItemService ;
    @Autowired
    private EtatReceptionAdminService etatReceptionService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReceptionAdminServiceImpl(ReceptionDao dao, ReceptionHistoryDao historyDao) {
        super(dao, historyDao);
    }

}