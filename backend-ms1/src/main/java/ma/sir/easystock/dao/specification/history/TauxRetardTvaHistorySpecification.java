package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.easystock.bean.history.TauxRetardTvaHistory;


public class TauxRetardTvaHistorySpecification extends AbstractHistorySpecification<TauxRetardTvaHistoryCriteria, TauxRetardTvaHistory> {

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
