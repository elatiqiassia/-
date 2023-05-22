package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.ProprietaireCheque;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeCriteria;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;

import ma.sir.easystock.ws.dto.ProprietaireChequeDto;
import org.springframework.http.HttpEntity;

public interface ProprietaireChequeAdminService extends  IService<ProprietaireCheque,ProprietaireChequeCriteria, ProprietaireChequeHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ProprietaireChequeDto dto) throws Exception;


}
