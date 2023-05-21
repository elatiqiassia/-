package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.FournisseurHistoryCriteria;
import ma.sir.easystock.bean.history.FournisseurHistory;


public class FournisseurHistorySpecification extends AbstractHistorySpecification<FournisseurHistoryCriteria, FournisseurHistory> {

    public FournisseurHistorySpecification(FournisseurHistoryCriteria criteria) {
        super(criteria);
    }

    public FournisseurHistorySpecification(FournisseurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
