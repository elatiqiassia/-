package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ComptableValidateurCriteria;
import ma.sir.easystock.bean.core.ComptableValidateur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ComptableValidateurSpecification extends  AbstractSpecification<ComptableValidateurCriteria, ComptableValidateur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
    }

    public ComptableValidateurSpecification(ComptableValidateurCriteria criteria) {
        super(criteria);
    }

    public ComptableValidateurSpecification(ComptableValidateurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
