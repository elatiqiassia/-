package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AvoirAchatItemHistoryCriteria;
import ma.sir.easystock.bean.history.AvoirAchatItemHistory;


public class AvoirAchatItemHistorySpecification extends AbstractHistorySpecification<AvoirAchatItemHistoryCriteria, AvoirAchatItemHistory> {

    public AvoirAchatItemHistorySpecification(AvoirAchatItemHistoryCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatItemHistorySpecification(AvoirAchatItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
