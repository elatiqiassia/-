package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ModePaiementHistoryCriteria;
import ma.sir.easystock.bean.history.ModePaiementHistory;


public class ModePaiementHistorySpecification extends AbstractHistorySpecification<ModePaiementHistoryCriteria, ModePaiementHistory> {

    public ModePaiementHistorySpecification(ModePaiementHistoryCriteria criteria) {
        super(criteria);
    }

    public ModePaiementHistorySpecification(ModePaiementHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
