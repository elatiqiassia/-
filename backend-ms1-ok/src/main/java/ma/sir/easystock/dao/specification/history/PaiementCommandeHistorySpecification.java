package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.PaiementCommandeHistoryCriteria;
import ma.sir.easystock.bean.history.PaiementCommandeHistory;


public class PaiementCommandeHistorySpecification extends AbstractHistorySpecification<PaiementCommandeHistoryCriteria, PaiementCommandeHistory> {

    public PaiementCommandeHistorySpecification(PaiementCommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementCommandeHistorySpecification(PaiementCommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
