package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AbonneHistoryCriteria;
import ma.sir.easystock.bean.history.AbonneHistory;


public class AbonneHistorySpecification extends AbstractHistorySpecification<AbonneHistoryCriteria, AbonneHistory> {

    public AbonneHistorySpecification(AbonneHistoryCriteria criteria) {
        super(criteria);
    }

    public AbonneHistorySpecification(AbonneHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
