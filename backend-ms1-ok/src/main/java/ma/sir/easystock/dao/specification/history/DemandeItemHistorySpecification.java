package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DemandeItemHistoryCriteria;
import ma.sir.easystock.bean.history.DemandeItemHistory;


public class DemandeItemHistorySpecification extends AbstractHistorySpecification<DemandeItemHistoryCriteria, DemandeItemHistory> {

    public DemandeItemHistorySpecification(DemandeItemHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandeItemHistorySpecification(DemandeItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
