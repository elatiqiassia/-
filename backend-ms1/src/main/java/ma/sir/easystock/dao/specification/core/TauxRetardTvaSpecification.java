package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.easystock.bean.core.TauxRetardTva;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TauxRetardTvaSpecification extends  AbstractSpecification<TauxRetardTvaCriteria, TauxRetardTva>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateApplicationMin", criteria.getDateApplicationMin(), criteria.getDateApplicationMinFrom(), criteria.getDateApplicationMinTo());
        addPredicate("dateApplicationMax", criteria.getDateApplicationMax(), criteria.getDateApplicationMaxFrom(), criteria.getDateApplicationMaxTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
    }

    public TauxRetardTvaSpecification(TauxRetardTvaCriteria criteria) {
        super(criteria);
    }

    public TauxRetardTvaSpecification(TauxRetardTvaCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
