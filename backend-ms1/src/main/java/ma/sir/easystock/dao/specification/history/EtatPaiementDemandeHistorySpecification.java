package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementDemandeHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementDemandeHistory;


public class EtatPaiementDemandeHistorySpecification extends AbstractHistorySpecification<EtatPaiementDemandeHistoryCriteria, EtatPaiementDemandeHistory> {

    public EtatPaiementDemandeHistorySpecification(EtatPaiementDemandeHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementDemandeHistorySpecification(EtatPaiementDemandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
