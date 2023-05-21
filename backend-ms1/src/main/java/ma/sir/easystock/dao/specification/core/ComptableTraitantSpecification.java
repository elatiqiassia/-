package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ComptableTraitantCriteria;
import ma.sir.easystock.bean.core.ComptableTraitant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ComptableTraitantSpecification extends  AbstractSpecification<ComptableTraitantCriteria, ComptableTraitant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
    }

    public ComptableTraitantSpecification(ComptableTraitantCriteria criteria) {
        super(criteria);
    }

    public ComptableTraitantSpecification(ComptableTraitantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
