package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.DevisItemFournisseurHistoryCriteria;
import ma.sir.easystock.bean.history.DevisItemFournisseurHistory;


public class DevisItemFournisseurHistorySpecification extends AbstractHistorySpecification<DevisItemFournisseurHistoryCriteria, DevisItemFournisseurHistory> {

    public DevisItemFournisseurHistorySpecification(DevisItemFournisseurHistoryCriteria criteria) {
        super(criteria);
    }

    public DevisItemFournisseurHistorySpecification(DevisItemFournisseurHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
