package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ModePaiementCriteria;
import ma.sir.easystock.bean.core.ModePaiement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ModePaiementSpecification extends  AbstractSpecification<ModePaiementCriteria, ModePaiement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria) {
        super(criteria);
    }

    public ModePaiementSpecification(ModePaiementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
