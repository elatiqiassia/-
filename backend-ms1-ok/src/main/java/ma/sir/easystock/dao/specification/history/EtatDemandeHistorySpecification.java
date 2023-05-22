package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatDemandeHistoryCriteria;
import ma.sir.easystock.bean.history.EtatDemandeHistory;


public class EtatDemandeHistorySpecification extends AbstractHistorySpecification<EtatDemandeHistoryCriteria, EtatDemandeHistory> {

    public EtatDemandeHistorySpecification(EtatDemandeHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatDemandeHistorySpecification(EtatDemandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
