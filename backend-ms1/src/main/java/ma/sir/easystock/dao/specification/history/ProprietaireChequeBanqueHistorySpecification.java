package  ma.sir.easystock.dao.specification.history;

import ma.sir.easystock.zynerator.specification.AbstractHistorySpecification;
import ma.sir.easystock.dao.criteria.history.ProprietaireChequeBanqueHistoryCriteria;
import ma.sir.easystock.bean.history.ProprietaireChequeBanqueHistory;


public class ProprietaireChequeBanqueHistorySpecification extends AbstractHistorySpecification<ProprietaireChequeBanqueHistoryCriteria, ProprietaireChequeBanqueHistory> {

    public ProprietaireChequeBanqueHistorySpecification(ProprietaireChequeBanqueHistoryCriteria criteria) {
        super(criteria);
    }

    public ProprietaireChequeBanqueHistorySpecification(ProprietaireChequeBanqueHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
