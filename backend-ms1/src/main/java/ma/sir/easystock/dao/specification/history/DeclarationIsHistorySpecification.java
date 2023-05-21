package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.easystock.bean.history.DeclarationIsHistory;


public class DeclarationIsHistorySpecification extends AbstractHistorySpecification<DeclarationIsHistoryCriteria, DeclarationIsHistory> {

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
