package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.DevisItemFournisseurCriteria;
import ma.sir.easystock.bean.core.DevisItemFournisseur;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DevisItemFournisseurSpecification extends  AbstractSpecification<DevisItemFournisseurCriteria, DevisItemFournisseur>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("prixUnitaire", criteria.getPrixUnitaire(), criteria.getPrixUnitaireMin(), criteria.getPrixUnitaireMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("remise", criteria.getRemise(), criteria.getRemiseMin(), criteria.getRemiseMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("devisFournisseur","id", criteria.getDevisFournisseur()==null?null:criteria.getDevisFournisseur().getId());
        addPredicateFk("devisFournisseur","id", criteria.getDevisFournisseurs());
        addPredicateFk("devisFournisseur","reference", criteria.getDevisFournisseur()==null?null:criteria.getDevisFournisseur().getReference());
    }

    public DevisItemFournisseurSpecification(DevisItemFournisseurCriteria criteria) {
        super(criteria);
    }

    public DevisItemFournisseurSpecification(DevisItemFournisseurCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
