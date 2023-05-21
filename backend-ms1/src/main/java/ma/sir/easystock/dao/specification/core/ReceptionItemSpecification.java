package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.easystock.bean.core.ReceptionItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReceptionItemSpecification extends  AbstractSpecification<ReceptionItemCriteria, ReceptionItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("magasin","id", criteria.getMagasin()==null?null:criteria.getMagasin().getId());
        addPredicateFk("magasin","id", criteria.getMagasins());
        addPredicateFk("magasin","reference", criteria.getMagasin()==null?null:criteria.getMagasin().getReference());
        addPredicateFk("reception","id", criteria.getReception()==null?null:criteria.getReception().getId());
        addPredicateFk("reception","id", criteria.getReceptions());
        addPredicateFk("reception","reference", criteria.getReception()==null?null:criteria.getReception().getReference());
    }

    public ReceptionItemSpecification(ReceptionItemCriteria criteria) {
        super(criteria);
    }

    public ReceptionItemSpecification(ReceptionItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
