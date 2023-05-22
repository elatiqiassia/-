package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementCommandeHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementCommandeHistory;


public class EtatPaiementCommandeHistorySpecification extends AbstractHistorySpecification<EtatPaiementCommandeHistoryCriteria, EtatPaiementCommandeHistory> {

    public EtatPaiementCommandeHistorySpecification(EtatPaiementCommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementCommandeHistorySpecification(EtatPaiementCommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
