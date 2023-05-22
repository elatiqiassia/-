package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.easystock.bean.core.SousClassComptable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SousClassComptableSpecification extends  AbstractSpecification<SousClassComptableCriteria, SousClassComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("classComptable","id", criteria.getClassComptable()==null?null:criteria.getClassComptable().getId());
        addPredicateFk("classComptable","id", criteria.getClassComptables());
    }

    public SousClassComptableSpecification(SousClassComptableCriteria criteria) {
        super(criteria);
    }

    public SousClassComptableSpecification(SousClassComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
