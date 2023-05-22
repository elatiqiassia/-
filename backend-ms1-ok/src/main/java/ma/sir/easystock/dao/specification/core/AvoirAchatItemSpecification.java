package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.AvoirAchatItemCriteria;
import ma.sir.easystock.bean.core.AvoirAchatItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AvoirAchatItemSpecification extends  AbstractSpecification<AvoirAchatItemCriteria, AvoirAchatItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateFk("produit","id", criteria.getProduit()==null?null:criteria.getProduit().getId());
        addPredicateFk("produit","id", criteria.getProduits());
        addPredicateFk("produit","reference", criteria.getProduit()==null?null:criteria.getProduit().getReference());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchat()==null?null:criteria.getAvoirAchat().getId());
        addPredicateFk("avoirAchat","id", criteria.getAvoirAchats());
    }

    public AvoirAchatItemSpecification(AvoirAchatItemCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatItemSpecification(AvoirAchatItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
