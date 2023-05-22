package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Store;
import ma.sir.easystock.bean.history.StoreHistory;
import ma.sir.easystock.dao.criteria.core.StoreCriteria;
import ma.sir.easystock.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.easystock.dao.facade.core.StoreDao;
import ma.sir.easystock.dao.facade.history.StoreHistoryDao;
import ma.sir.easystock.dao.specification.core.StoreSpecification;
import ma.sir.easystock.service.facade.admin.StoreAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.StoreDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class StoreAdminServiceImpl extends AbstractServiceImpl<Store,StoreHistory, StoreCriteria, StoreHistoryCriteria, StoreDao,
StoreHistoryDao> implements StoreAdminService {
    public static final String TEMPLATE = "template/store.vm";
    public static final String FILE_NAME = "store.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(StoreDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Store findByReferenceEntity(Store t){
        return  dao.findByReference(t.getReference());
    }

    public List<Store> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }



    public void configure() {
        super.configure(Store.class,StoreHistory.class, StoreHistoryCriteria.class, StoreSpecification.class);
    }

    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public StoreAdminServiceImpl(StoreDao dao, StoreHistoryDao historyDao) {
        super(dao, historyDao);
    }

}