package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.easystock.bean.history.TauxIsHistory;


public class TauxIsHistorySpecification extends AbstractHistorySpecification<TauxIsHistoryCriteria, TauxIsHistory> {

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
