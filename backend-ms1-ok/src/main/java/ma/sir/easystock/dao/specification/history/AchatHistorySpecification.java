package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AchatHistoryCriteria;
import ma.sir.easystock.bean.history.AchatHistory;


public class AchatHistorySpecification extends AbstractHistorySpecification<AchatHistoryCriteria, AchatHistory> {

    public AchatHistorySpecification(AchatHistoryCriteria criteria) {
        super(criteria);
    }

    public AchatHistorySpecification(AchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
