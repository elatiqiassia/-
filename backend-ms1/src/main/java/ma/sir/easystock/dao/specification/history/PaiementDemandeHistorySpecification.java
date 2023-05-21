package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.PaiementDemandeHistoryCriteria;
import ma.sir.easystock.bean.history.PaiementDemandeHistory;


public class PaiementDemandeHistorySpecification extends AbstractHistorySpecification<PaiementDemandeHistoryCriteria, PaiementDemandeHistory> {

    public PaiementDemandeHistorySpecification(PaiementDemandeHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementDemandeHistorySpecification(PaiementDemandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
