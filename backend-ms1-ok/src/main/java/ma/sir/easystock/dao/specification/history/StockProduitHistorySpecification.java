package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.StockProduitHistoryCriteria;
import ma.sir.easystock.bean.history.StockProduitHistory;


public class StockProduitHistorySpecification extends AbstractHistorySpecification<StockProduitHistoryCriteria, StockProduitHistory> {

    public StockProduitHistorySpecification(StockProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public StockProduitHistorySpecification(StockProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
