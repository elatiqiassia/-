package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DevisFournisseurHistoryCriteria;
import ma.sir.easystock.bean.history.DevisFournisseurHistory;


public class DevisFournisseurHistorySpecification extends AbstractHistorySpecification<DevisFournisseurHistoryCriteria, DevisFournisseurHistory> {

    public DevisFournisseurHistorySpecification(DevisFournisseurHistoryCriteria criteria) {
        super(criteria);
    }

    public DevisFournisseurHistorySpecification(DevisFournisseurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
