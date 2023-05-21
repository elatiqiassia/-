package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatVenteHistoryCriteria;
import ma.sir.easystock.bean.history.EtatVenteHistory;


public class EtatVenteHistorySpecification extends AbstractHistorySpecification<EtatVenteHistoryCriteria, EtatVenteHistory> {

    public EtatVenteHistorySpecification(EtatVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatVenteHistorySpecification(EtatVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
