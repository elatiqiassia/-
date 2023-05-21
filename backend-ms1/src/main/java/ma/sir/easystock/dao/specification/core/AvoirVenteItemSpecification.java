package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.AvoirVenteItemCriteria;
import ma.sir.easystock.bean.core.AvoirVenteItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AvoirVenteItemSpecification extends  AbstractSpecification<AvoirVenteItemCriteria, AvoirVenteItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("montantAvoir", criteria.getMontantAvoir(), criteria.getMontantAvoirMin(), criteria.getMontantAvoirMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("avoirVente","id", criteria.getAvoirVente()==null?null:criteria.getAvoirVente().getId());
        addPredicateFk("avoirVente","id", criteria.getAvoirVentes());
    }

    public AvoirVenteItemSpecification(AvoirVenteItemCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteItemSpecification(AvoirVenteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
