package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementLivraisonHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementLivraisonHistory;


public class EtatPaiementLivraisonHistorySpecification extends AbstractHistorySpecification<EtatPaiementLivraisonHistoryCriteria, EtatPaiementLivraisonHistory> {

    public EtatPaiementLivraisonHistorySpecification(EtatPaiementLivraisonHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementLivraisonHistorySpecification(EtatPaiementLivraisonHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
