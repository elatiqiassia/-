package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.CompteComptable;
import ma.sir.easystock.bean.history.CompteComptableHistory;
import ma.sir.easystock.dao.criteria.core.CompteComptableCriteria;
import ma.sir.easystock.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.easystock.dao.facade.core.CompteComptableDao;
import ma.sir.easystock.dao.facade.history.CompteComptableHistoryDao;
import ma.sir.easystock.dao.specification.core.CompteComptableSpecification;
import ma.sir.easystock.service.facade.admin.CompteComptableAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.CompteComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.easystock.service.facade.admin.SousClassComptableAdminService ;


import java.util.List;
@Service
public class CompteComptableAdminServiceImpl extends AbstractServiceImpl<CompteComptable,CompteComptableHistory, CompteComptableCriteria, CompteComptableHistoryCriteria, CompteComptableDao,
CompteComptableHistoryDao> implements CompteComptableAdminService {
    public static final String TEMPLATE = "template/compteComptable.vm";
    public static final String FILE_NAME = "compteComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CompteComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<CompteComptable> findBySousClassComptableId(Long id){
        return dao.findBySousClassComptableId(id);
    }
    public int deleteBySousClassComptableId(Long id){
        return dao.deleteBySousClassComptableId(id);
    }



    public void configure() {
        super.configure(CompteComptable.class,CompteComptableHistory.class, CompteComptableHistoryCriteria.class, CompteComptableSpecification.class);
    }

    @Autowired
    private SousClassComptableAdminService sousClassComptableService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public CompteComptableAdminServiceImpl(CompteComptableDao dao, CompteComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}