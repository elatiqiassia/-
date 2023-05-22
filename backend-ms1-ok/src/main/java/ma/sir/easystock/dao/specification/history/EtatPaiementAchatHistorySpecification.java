package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatPaiementAchatHistoryCriteria;
import ma.sir.easystock.bean.history.EtatPaiementAchatHistory;


public class EtatPaiementAchatHistorySpecification extends AbstractHistorySpecification<EtatPaiementAchatHistoryCriteria, EtatPaiementAchatHistory> {

    public EtatPaiementAchatHistorySpecification(EtatPaiementAchatHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatPaiementAchatHistorySpecification(EtatPaiementAchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
