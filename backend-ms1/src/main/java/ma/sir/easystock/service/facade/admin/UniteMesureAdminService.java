package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.UniteMesure;
import ma.sir.easystock.dao.criteria.core.UniteMesureCriteria;
import ma.sir.easystock.dao.criteria.history.UniteMesureHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.UniteMesureDto;
import org.springframework.http.HttpEntity;

public interface UniteMesureAdminService extends  IService<UniteMesure,UniteMesureCriteria, UniteMesureHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(UniteMesureDto dto) throws Exception;


}
