package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.CommandeHistoryCriteria;
import ma.sir.easystock.bean.history.CommandeHistory;


public class CommandeHistorySpecification extends AbstractHistorySpecification<CommandeHistoryCriteria, CommandeHistory> {

    public CommandeHistorySpecification(CommandeHistoryCriteria criteria) {
        super(criteria);
    }

    public CommandeHistorySpecification(CommandeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
