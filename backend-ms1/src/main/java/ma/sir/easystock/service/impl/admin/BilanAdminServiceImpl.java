package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.Bilan;
import ma.sir.easystock.bean.history.BilanHistory;
import ma.sir.easystock.dao.criteria.core.BilanCriteria;
import ma.sir.easystock.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.easystock.dao.facade.core.BilanDao;
import ma.sir.easystock.dao.facade.history.BilanHistoryDao;
import ma.sir.easystock.dao.specification.core.BilanSpecification;
import ma.sir.easystock.service.facade.admin.BilanAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.BilanDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class BilanAdminServiceImpl extends AbstractServiceImpl<Bilan,BilanHistory, BilanCriteria, BilanHistoryCriteria, BilanDao,
BilanHistoryDao> implements BilanAdminService {
    public static final String TEMPLATE = "template/bilan.vm";
    public static final String FILE_NAME = "bilan.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(BilanDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Bilan findByReferenceEntity(Bilan t){
        return  dao.findByRef(t.getRef());
    }

    public List<Bilan> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }



    public void configure() {
        super.configure(Bilan.class,BilanHistory.class, BilanHistoryCriteria.class, BilanSpecification.class);
    }

    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public BilanAdminServiceImpl(BilanDao dao, BilanHistoryDao historyDao) {
        super(dao, historyDao);
    }

}