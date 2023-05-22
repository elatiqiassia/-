package ma.sir.easystock.service.facade.admin;

import java.util.List;
import ma.sir.easystock.bean.core.EtatDemande;
import ma.sir.easystock.dao.criteria.core.EtatDemandeCriteria;
import ma.sir.easystock.dao.criteria.history.EtatDemandeHistoryCriteria;
import ma.sir.easystock.zynerator.service.IService;


public interface EtatDemandeAdminService extends  IService<EtatDemande,EtatDemandeCriteria, EtatDemandeHistoryCriteria>  {




}
