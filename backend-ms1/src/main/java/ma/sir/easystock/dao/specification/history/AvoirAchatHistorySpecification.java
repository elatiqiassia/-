package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AvoirAchatHistoryCriteria;
import ma.sir.easystock.bean.history.AvoirAchatHistory;


public class AvoirAchatHistorySpecification extends AbstractHistorySpecification<AvoirAchatHistoryCriteria, AvoirAchatHistory> {

    public AvoirAchatHistorySpecification(AvoirAchatHistoryCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatHistorySpecification(AvoirAchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
