package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementVenteHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementVenteHistory;


public class EtatPaiementVenteHistorySpecification extends AbstractHistorySpecification<EtatPaiementVenteHistoryCriteria, EtatPaiementVenteHistory> {

    public EtatPaiementVenteHistorySpecification(EtatPaiementVenteHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementVenteHistorySpecification(EtatPaiementVenteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
