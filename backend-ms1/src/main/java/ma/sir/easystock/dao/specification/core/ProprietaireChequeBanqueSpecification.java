package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ProprietaireChequeBanqueCriteria;
import ma.sir.easystock.bean.core.ProprietaireChequeBanque;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProprietaireChequeBanqueSpecification extends  AbstractSpecification<ProprietaireChequeBanqueCriteria, ProprietaireChequeBanque>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("proprietaireCheque","id", criteria.getProprietaireCheque()==null?null:criteria.getProprietaireCheque().getId());
        addPredicateFk("proprietaireCheque","id", criteria.getProprietaireCheques());
        addPredicateFk("banque","id", criteria.getBanque()==null?null:criteria.getBanque().getId());
        addPredicateFk("banque","id", criteria.getBanques());
    }

    public ProprietaireChequeBanqueSpecification(ProprietaireChequeBanqueCriteria criteria) {
        super(criteria);
    }

    public ProprietaireChequeBanqueSpecification(ProprietaireChequeBanqueCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
