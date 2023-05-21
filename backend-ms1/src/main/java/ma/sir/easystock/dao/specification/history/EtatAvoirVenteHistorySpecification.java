package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatAvoirVenteHistoryCriteria;
import ma.sir.easystock.bean.history.EtatAvoirVenteHistory;


public class EtatAvoirVenteHistorySpecification extends AbstractHistorySpecification<EtatAvoirVenteHistoryCriteria, EtatAvoirVenteHistory> {

    public EtatAvoirVenteHistorySpecification(EtatAvoirVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirVenteHistorySpecification(EtatAvoirVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
