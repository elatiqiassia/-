package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AvoirVenteItemHistoryCriteria;
import ma.sir.easystock.bean.history.AvoirVenteItemHistory;


public class AvoirVenteItemHistorySpecification extends AbstractHistorySpecification<AvoirVenteItemHistoryCriteria, AvoirVenteItemHistory> {

    public AvoirVenteItemHistorySpecification(AvoirVenteItemHistoryCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteItemHistorySpecification(AvoirVenteItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
