package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.easystock.bean.history.VenteHistory;


public class VenteHistorySpecification extends AbstractHistorySpecification<VenteHistoryCriteria, VenteHistory> {

    public VenteHistorySpecification(VenteHistoryCriteria criteria) {
        super(criteria);
    }

    public VenteHistorySpecification(VenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
