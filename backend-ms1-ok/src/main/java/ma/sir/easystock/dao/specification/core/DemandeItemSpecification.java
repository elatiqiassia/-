package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.DemandeItemCriteria;
import ma.sir.easystock.bean.core.DemandeItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DemandeItemSpecification extends  AbstractSpecification<DemandeItemCriteria, DemandeItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("prix", criteria.getPrix(), criteria.getPrixMin(), criteria.getPrixMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("quantiteLivre", criteria.getQuantiteLivre(), criteria.getQuantiteLivreMin(), criteria.getQuantiteLivreMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("demande","id", criteria.getDemande()==null?null:criteria.getDemande().getId());
        addPredicateFk("demande","id", criteria.getDemandes());
        addPredicateFk("demande","reference", criteria.getDemande()==null?null:criteria.getDemande().getReference());
    }

    public DemandeItemSpecification(DemandeItemCriteria criteria) {
        super(criteria);
    }

    public DemandeItemSpecification(DemandeItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
