package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.easystock.bean.history.ClassComptableHistory;


public class ClassComptableHistorySpecification extends AbstractHistorySpecification<ClassComptableHistoryCriteria, ClassComptableHistory> {

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
