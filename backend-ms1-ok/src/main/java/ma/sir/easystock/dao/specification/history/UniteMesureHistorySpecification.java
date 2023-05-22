package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.UniteMesureHistoryCriteria;
import ma.sir.easystock.bean.history.UniteMesureHistory;


public class UniteMesureHistorySpecification extends AbstractHistorySpecification<UniteMesureHistoryCriteria, UniteMesureHistory> {

    public UniteMesureHistorySpecification(UniteMesureHistoryCriteria criteria) {
        super(criteria);
    }

    public UniteMesureHistorySpecification(UniteMesureHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
