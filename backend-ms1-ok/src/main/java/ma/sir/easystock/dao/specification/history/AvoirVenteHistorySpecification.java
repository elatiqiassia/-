package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.AvoirVenteHistoryCriteria;
import ma.sir.easystock.bean.history.AvoirVenteHistory;


public class AvoirVenteHistorySpecification extends AbstractHistorySpecification<AvoirVenteHistoryCriteria, AvoirVenteHistory> {

    public AvoirVenteHistorySpecification(AvoirVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteHistorySpecification(AvoirVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
