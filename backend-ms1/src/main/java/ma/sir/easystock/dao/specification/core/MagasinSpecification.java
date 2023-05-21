package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.MagasinCriteria;
import ma.sir.easystock.bean.core.Magasin;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MagasinSpecification extends  AbstractSpecification<MagasinCriteria, Magasin>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("adresse", criteria.getAdresse(),criteria.getAdresseLike());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
    }

    public MagasinSpecification(MagasinCriteria criteria) {
        super(criteria);
    }

    public MagasinSpecification(MagasinCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
