package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.LivraisonHistoryCriteria;
import ma.sir.easystock.bean.history.LivraisonHistory;


public class LivraisonHistorySpecification extends AbstractHistorySpecification<LivraisonHistoryCriteria, LivraisonHistory> {

    public LivraisonHistorySpecification(LivraisonHistoryCriteria criteria) {
        super(criteria);
    }

    public LivraisonHistorySpecification(LivraisonHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
