package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.TauxIsCriteria;
import ma.sir.easystock.bean.core.TauxIs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TauxIsSpecification extends  AbstractSpecification<TauxIsCriteria, TauxIs>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("resultatMin", criteria.getResultatMin(), criteria.getResultatMinMin(), criteria.getResultatMinMax());
        addPredicateBigDecimal("resultatMax", criteria.getResultatMax(), criteria.getResultatMaxMin(), criteria.getResultatMaxMax());
        addPredicate("dateApplicationMin", criteria.getDateApplicationMin(), criteria.getDateApplicationMinFrom(), criteria.getDateApplicationMinTo());
        addPredicate("dateApplicationMax", criteria.getDateApplicationMax(), criteria.getDateApplicationMaxFrom(), criteria.getDateApplicationMaxTo());
        addPredicateBigDecimal("pourcentage", criteria.getPourcentage(), criteria.getPourcentageMin(), criteria.getPourcentageMax());
    }

    public TauxIsSpecification(TauxIsCriteria criteria) {
        super(criteria);
    }

    public TauxIsSpecification(TauxIsCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
