package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatAvoirAchatHistoryCriteria;
import ma.sir.easystock.bean.history.EtatAvoirAchatHistory;


public class EtatAvoirAchatHistorySpecification extends AbstractHistorySpecification<EtatAvoirAchatHistoryCriteria, EtatAvoirAchatHistory> {

    public EtatAvoirAchatHistorySpecification(EtatAvoirAchatHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirAchatHistorySpecification(EtatAvoirAchatHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
