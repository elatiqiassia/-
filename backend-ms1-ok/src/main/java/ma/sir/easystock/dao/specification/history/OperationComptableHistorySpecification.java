package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.easystock.bean.history.OperationComptableHistory;


public class OperationComptableHistorySpecification extends AbstractHistorySpecification<OperationComptableHistoryCriteria, OperationComptableHistory> {

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
