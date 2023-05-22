package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatAchatHistoryCriteria;
import ma.sir.easystock.bean.history.EtatAchatHistory;


public class EtatAchatHistorySpecification extends AbstractHistorySpecification<EtatAchatHistoryCriteria, EtatAchatHistory> {

    public EtatAchatHistorySpecification(EtatAchatHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatAchatHistorySpecification(EtatAchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
