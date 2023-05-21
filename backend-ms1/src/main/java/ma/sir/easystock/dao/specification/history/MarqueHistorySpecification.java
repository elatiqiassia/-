package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.MarqueHistoryCriteria;
import ma.sir.easystock.bean.history.MarqueHistory;


public class MarqueHistorySpecification extends AbstractHistorySpecification<MarqueHistoryCriteria, MarqueHistory> {

    public MarqueHistorySpecification(MarqueHistoryCriteria criteria) {
        super(criteria);
    }

    public MarqueHistorySpecification(MarqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
