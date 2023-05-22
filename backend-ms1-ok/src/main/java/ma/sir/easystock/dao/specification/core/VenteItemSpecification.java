package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.VenteItemCriteria;
import ma.sir.easystock.bean.core.VenteItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VenteItemSpecification extends  AbstractSpecification<VenteItemCriteria, VenteItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("prixUnitaire", criteria.getPrixUnitaire(), criteria.getPrixUnitaireMin(), criteria.getPrixUnitaireMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateBigDecimal("quantiteAvoir", criteria.getQuantiteAvoir(), criteria.getQuantiteAvoirMin(), criteria.getQuantiteAvoirMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","reference", criteria.getVente()==null?null:criteria.getVente().getReference());
    }

    public VenteItemSpecification(VenteItemCriteria criteria) {
        super(criteria);
    }

    public VenteItemSpecification(VenteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
