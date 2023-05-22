package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatLivraisonHistoryCriteria;
import ma.sir.easystock.bean.history.EtatLivraisonHistory;


public class EtatLivraisonHistorySpecification extends AbstractHistorySpecification<EtatLivraisonHistoryCriteria, EtatLivraisonHistory> {

    public EtatLivraisonHistorySpecification(EtatLivraisonHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatLivraisonHistorySpecification(EtatLivraisonHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
