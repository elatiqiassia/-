package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.easystock.bean.history.SocieteHistory;


public class SocieteHistorySpecification extends AbstractHistorySpecification<SocieteHistoryCriteria, SocieteHistory> {

    public SocieteHistorySpecification(SocieteHistoryCriteria criteria) {
        super(criteria);
    }

    public SocieteHistorySpecification(SocieteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
