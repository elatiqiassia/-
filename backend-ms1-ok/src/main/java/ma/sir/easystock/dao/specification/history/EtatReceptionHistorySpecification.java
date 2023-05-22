package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.EtatReceptionHistoryCriteria;
import ma.sir.easystock.bean.history.EtatReceptionHistory;


public class EtatReceptionHistorySpecification extends AbstractHistorySpecification<EtatReceptionHistoryCriteria, EtatReceptionHistory> {

    public EtatReceptionHistorySpecification(EtatReceptionHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatReceptionHistorySpecification(EtatReceptionHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
