package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeHistoryCriteria;
import ma.sir.easystock.bean.history.ProprietaireChequeHistory;


public class ProprietaireChequeHistorySpecification extends AbstractHistorySpecification<ProprietaireChequeHistoryCriteria, ProprietaireChequeHistory> {

    public ProprietaireChequeHistorySpecification(ProprietaireChequeHistoryCriteria criteria) {
        super(criteria);
    }

    public ProprietaireChequeHistorySpecification(ProprietaireChequeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
