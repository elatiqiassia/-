package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DemandeHistoryCriteria;
import ma.sir.easystock.bean.history.DemandeHistory;


public class DemandeHistorySpecification extends AbstractHistorySpecification<DemandeHistoryCriteria, DemandeHistory> {

    public DemandeHistorySpecification(DemandeHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandeHistorySpecification(DemandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
