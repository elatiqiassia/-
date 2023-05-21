package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Magasin;
import ma.sir.easystock.bean.history.MagasinHistory;
import ma.sir.easystock.dao.criteria.core.MagasinCriteria;
import ma.sir.easystock.dao.criteria.history.MagasinHistoryCriteria;
import ma.sir.easystock.dao.facade.core.MagasinDao;
import ma.sir.easystock.dao.facade.history.MagasinHistoryDao;
import ma.sir.easystock.dao.specification.core.MagasinSpecification;
import ma.sir.easystock.service.facade.admin.MagasinAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.MagasinDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.StoreAdminService ;


import java.util.List;
@Service
public class MagasinAdminServiceImpl extends AbstractServiceImpl<Magasin,MagasinHistory, MagasinCriteria, MagasinHistoryCriteria, MagasinDao,
MagasinHistoryDao> implements MagasinAdminService {
    public static final String TEMPLATE = "template/magasin.vm";
    public static final String FILE_NAME = "magasin.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(MagasinDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Magasin findByReferenceEntity(Magasin t){
        return  dao.findByReference(t.getReference());
    }

    public List<Magasin> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }



    public void configure() {
        super.configure(Magasin.class,MagasinHistory.class, MagasinHistoryCriteria.class, MagasinSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public MagasinAdminServiceImpl(MagasinDao dao, MagasinHistoryDao historyDao) {
        super(dao, historyDao);
    }

}