package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.easystock.bean.history.StoreHistory;


public class StoreHistorySpecification extends AbstractHistorySpecification<StoreHistoryCriteria, StoreHistory> {

    public StoreHistorySpecification(StoreHistoryCriteria criteria) {
        super(criteria);
    }

    public StoreHistorySpecification(StoreHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
