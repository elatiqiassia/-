package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.EtatAvoirVenteCriteria;
import ma.sir.easystock.bean.core.EtatAvoirVente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EtatAvoirVenteSpecification extends  AbstractSpecification<EtatAvoirVenteCriteria, EtatAvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria) {
        super(criteria);
    }

    public EtatAvoirVenteSpecification(EtatAvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
