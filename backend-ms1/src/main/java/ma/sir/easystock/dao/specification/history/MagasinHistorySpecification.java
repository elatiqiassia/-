package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.MagasinHistoryCriteria;
import ma.sir.easystock.bean.history.MagasinHistory;


public class MagasinHistorySpecification extends AbstractHistorySpecification<MagasinHistoryCriteria, MagasinHistory> {

    public MagasinHistorySpecification(MagasinHistoryCriteria criteria) {
        super(criteria);
    }

    public MagasinHistorySpecification(MagasinHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
