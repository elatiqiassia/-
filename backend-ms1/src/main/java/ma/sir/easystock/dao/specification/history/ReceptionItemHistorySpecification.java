package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.easystock.bean.history.ReceptionItemHistory;


public class ReceptionItemHistorySpecification extends AbstractHistorySpecification<ReceptionItemHistoryCriteria, ReceptionItemHistory> {

    public ReceptionItemHistorySpecification(ReceptionItemHistoryCriteria criteria) {
        super(criteria);
    }

    public ReceptionItemHistorySpecification(ReceptionItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
