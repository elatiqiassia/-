package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.CommandeItemHistoryCriteria;
import ma.sir.easystock.bean.history.CommandeItemHistory;


public class CommandeItemHistorySpecification extends AbstractHistorySpecification<CommandeItemHistoryCriteria, CommandeItemHistory> {

    public CommandeItemHistorySpecification(CommandeItemHistoryCriteria criteria) {
        super(criteria);
    }

    public CommandeItemHistorySpecification(CommandeItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
