package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ComptableValidateurHistoryCriteria;
import ma.sir.easystock.bean.history.ComptableValidateurHistory;


public class ComptableValidateurHistorySpecification extends AbstractHistorySpecification<ComptableValidateurHistoryCriteria, ComptableValidateurHistory> {

    public ComptableValidateurHistorySpecification(ComptableValidateurHistoryCriteria criteria) {
        super(criteria);
    }

    public ComptableValidateurHistorySpecification(ComptableValidateurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
