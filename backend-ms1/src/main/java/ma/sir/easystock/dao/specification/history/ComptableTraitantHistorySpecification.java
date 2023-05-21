package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ComptableTraitantHistoryCriteria;
import ma.sir.easystock.bean.history.ComptableTraitantHistory;


public class ComptableTraitantHistorySpecification extends AbstractHistorySpecification<ComptableTraitantHistoryCriteria, ComptableTraitantHistory> {

    public ComptableTraitantHistorySpecification(ComptableTraitantHistoryCriteria criteria) {
        super(criteria);
    }

    public ComptableTraitantHistorySpecification(ComptableTraitantHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
