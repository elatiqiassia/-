package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatCommandeHistoryCriteria;
import ma.sir.easystock.bean.history.EtatCommandeHistory;


public class EtatCommandeHistorySpecification extends AbstractHistorySpecification<EtatCommandeHistoryCriteria, EtatCommandeHistory> {

    public EtatCommandeHistorySpecification(EtatCommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatCommandeHistorySpecification(EtatCommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
