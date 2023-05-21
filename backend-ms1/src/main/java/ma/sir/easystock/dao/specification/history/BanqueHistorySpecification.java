package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.BanqueHistoryCriteria;
import ma.sir.easystock.bean.history.BanqueHistory;


public class BanqueHistorySpecification extends AbstractHistorySpecification<BanqueHistoryCriteria, BanqueHistory> {

    public BanqueHistorySpecification(BanqueHistoryCriteria criteria) {
        super(criteria);
    }

    public BanqueHistorySpecification(BanqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
