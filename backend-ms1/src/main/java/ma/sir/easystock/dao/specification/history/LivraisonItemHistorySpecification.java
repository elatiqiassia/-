package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.LivraisonItemHistoryCriteria;
import ma.sir.easystock.bean.history.LivraisonItemHistory;


public class LivraisonItemHistorySpecification extends AbstractHistorySpecification<LivraisonItemHistoryCriteria, LivraisonItemHistory> {

    public LivraisonItemHistorySpecification(LivraisonItemHistoryCriteria criteria) {
        super(criteria);
    }

    public LivraisonItemHistorySpecification(LivraisonItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
