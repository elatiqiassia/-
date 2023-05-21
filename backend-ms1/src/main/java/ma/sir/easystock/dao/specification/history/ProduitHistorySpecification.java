package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ProduitHistoryCriteria;
import ma.sir.easystock.bean.history.ProduitHistory;


public class ProduitHistorySpecification extends AbstractHistorySpecification<ProduitHistoryCriteria, ProduitHistory> {

    public ProduitHistorySpecification(ProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public ProduitHistorySpecification(ProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
