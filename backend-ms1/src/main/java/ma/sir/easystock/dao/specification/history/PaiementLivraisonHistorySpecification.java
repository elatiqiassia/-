package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.PaiementLivraisonHistoryCriteria;
import ma.sir.easystock.bean.history.PaiementLivraisonHistory;


public class PaiementLivraisonHistorySpecification extends AbstractHistorySpecification<PaiementLivraisonHistoryCriteria, PaiementLivraisonHistory> {

    public PaiementLivraisonHistorySpecification(PaiementLivraisonHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementLivraisonHistorySpecification(PaiementLivraisonHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
