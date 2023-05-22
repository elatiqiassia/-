package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.easystock.bean.history.DeclarationTvaHistory;


public class DeclarationTvaHistorySpecification extends AbstractHistorySpecification<DeclarationTvaHistoryCriteria, DeclarationTvaHistory> {

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
