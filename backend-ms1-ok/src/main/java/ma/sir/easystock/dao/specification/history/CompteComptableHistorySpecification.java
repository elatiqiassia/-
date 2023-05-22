package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.easystock.bean.history.CompteComptableHistory;


public class CompteComptableHistorySpecification extends AbstractHistorySpecification<CompteComptableHistoryCriteria, CompteComptableHistory> {

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
