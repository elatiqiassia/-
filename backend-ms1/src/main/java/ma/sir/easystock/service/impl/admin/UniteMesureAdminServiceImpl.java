package ma.sir.easystock.service.impl.admin;

import ma.sir.easystock.bean.core.UniteMesure;
import ma.sir.easystock.bean.history.UniteMesureHistory;
import ma.sir.easystock.dao.criteria.core.UniteMesureCriteria;
import ma.sir.easystock.dao.criteria.history.UniteMesureHistoryCriteria;
import ma.sir.easystock.dao.facade.core.UniteMesureDao;
import ma.sir.easystock.dao.facade.history.UniteMesureHistoryDao;
import ma.sir.easystock.dao.specification.core.UniteMesureSpecification;
import ma.sir.easystock.service.facade.admin.UniteMesureAdminService;
import ma.sir.easystock.zynerator.service.AbstractServiceImpl;
import ma.sir.easystock.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.easystock.zynerator.util.VelocityPdf;
import ma.sir.easystock.ws.dto.UniteMesureDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class UniteMesureAdminServiceImpl extends AbstractServiceImpl<UniteMesure,UniteMesureHistory, UniteMesureCriteria, UniteMesureHistoryCriteria, UniteMesureDao,
UniteMesureHistoryDao> implements UniteMesureAdminService {
    public static final String TEMPLATE = "template/uniteMesure.vm";
    public static final String FILE_NAME = "uniteMesure.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public UniteMesure findByReferenceEntity(UniteMesure t){
        return  dao.findByCode(t.getCode());
    }




    public void configure() {
        super.configure(UniteMesure.class,UniteMesureHistory.class, UniteMesureHistoryCriteria.class, UniteMesureSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public UniteMesureAdminServiceImpl(UniteMesureDao dao, UniteMesureHistoryDao historyDao) {
        super(dao, historyDao);
    }

}