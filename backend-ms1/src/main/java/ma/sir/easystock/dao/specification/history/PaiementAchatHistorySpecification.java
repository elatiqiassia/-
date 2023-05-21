package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.PaiementAchatHistoryCriteria;
import ma.sir.easystock.bean.history.PaiementAchatHistory;


public class PaiementAchatHistorySpecification extends AbstractHistorySpecification<PaiementAchatHistoryCriteria, PaiementAchatHistory> {

    public PaiementAchatHistorySpecification(PaiementAchatHistoryCriteria criteria) {
        super(criteria);
    }

    public PaiementAchatHistorySpecification(PaiementAchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
