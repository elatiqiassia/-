package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.easystock.bean.history.ReceptionHistory;


public class ReceptionHistorySpecification extends AbstractHistorySpecification<ReceptionHistoryCriteria, ReceptionHistory> {

    public ReceptionHistorySpecification(ReceptionHistoryCriteria criteria) {
        super(criteria);
    }

    public ReceptionHistorySpecification(ReceptionHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
