package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.StockProduitCriteria;
import ma.sir.easystock.bean.core.StockProduit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StockProduitSpecification extends  AbstractSpecification<StockProduitCriteria, StockProduit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("quantiteDeffecteuse", criteria.getQuantiteDeffecteuse(), criteria.getQuantiteDeffecteuseMin(), criteria.getQuantiteDeffecteuseMax());
        addPredicateFk("magasin","id", criteria.getMagasin()==null?null:criteria.getMagasin().getId());
        addPredicateFk("magasin","id", criteria.getMagasins());
        addPredicateFk("magasin","reference", criteria.getMagasin()==null?null:criteria.getMagasin().getReference());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
    }

    public StockProduitSpecification(StockProduitCriteria criteria) {
        super(criteria);
    }

    public StockProduitSpecification(StockProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
