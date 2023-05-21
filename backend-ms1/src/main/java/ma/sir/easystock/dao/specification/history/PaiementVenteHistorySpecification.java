package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.PaiementVenteHistoryCriteria;
import ma.sir.easystock.bean.history.PaiementVenteHistory;


public class PaiementVenteHistorySpecification extends AbstractHistorySpecification<PaiementVenteHistoryCriteria, PaiementVenteHistory> {

    public PaiementVenteHistorySpecification(PaiementVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementVenteHistorySpecification(PaiementVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
