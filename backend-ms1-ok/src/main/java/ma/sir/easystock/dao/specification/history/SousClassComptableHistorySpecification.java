package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.easystock.bean.history.SousClassComptableHistory;


public class SousClassComptableHistorySpecification extends AbstractHistorySpecification<SousClassComptableHistoryCriteria, SousClassComptableHistory> {

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
