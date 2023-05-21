package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.CompteComptableCriteria;
import ma.sir.easystock.bean.core.CompteComptable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CompteComptableSpecification extends  AbstractSpecification<CompteComptableCriteria, CompteComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("sousClassComptable","id", criteria.getSousClassComptable()==null?null:criteria.getSousClassComptable().getId());
        addPredicateFk("sousClassComptable","id", criteria.getSousClassComptables());
    }

    public CompteComptableSpecification(CompteComptableCriteria criteria) {
        super(criteria);
    }

    public CompteComptableSpecification(CompteComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
