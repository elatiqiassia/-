package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.VenteItemHistoryCriteria;
import ma.sir.easystock.bean.history.VenteItemHistory;


public class VenteItemHistorySpecification extends AbstractHistorySpecification<VenteItemHistoryCriteria, VenteItemHistory> {

    public VenteItemHistorySpecification(VenteItemHistoryCriteria criteria) {
        super(criteria);
    }

    public VenteItemHistorySpecification(VenteItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
