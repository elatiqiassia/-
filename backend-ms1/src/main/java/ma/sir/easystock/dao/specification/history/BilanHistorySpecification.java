package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.easystock.bean.history.BilanHistory;


public class BilanHistorySpecification extends AbstractHistorySpecification<BilanHistoryCriteria, BilanHistory> {

    public BilanHistorySpecification(BilanHistoryCriteria criteria) {
        super(criteria);
    }

    public BilanHistorySpecification(BilanHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
