package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AchatItemHistoryCriteria;
import ma.sir.easystock.bean.history.AchatItemHistory;


public class AchatItemHistorySpecification extends AbstractHistorySpecification<AchatItemHistoryCriteria, AchatItemHistory> {

    public AchatItemHistorySpecification(AchatItemHistoryCriteria criteria) {
        super(criteria);
    }

    public AchatItemHistorySpecification(AchatItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
