package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.AvoirAchatCriteria;
import ma.sir.easystock.bean.core.AvoirAchat;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AvoirAchatSpecification extends  AbstractSpecification<AvoirAchatCriteria, AvoirAchat>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateAvoir", criteria.getDateAvoir(), criteria.getDateAvoirFrom(), criteria.getDateAvoirTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("achat","id", criteria.getAchat()==null?null:criteria.getAchat().getId());
        addPredicateFk("achat","id", criteria.getAchats());
        addPredicateFk("achat","reference", criteria.getAchat()==null?null:criteria.getAchat().getReference());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchat()==null?null:criteria.getEtatAvoirAchat().getId());
        addPredicateFk("etatAvoirAchat","id", criteria.getEtatAvoirAchats());
        addPredicateFk("etatAvoirAchat","code", criteria.getEtatAvoirAchat()==null?null:criteria.getEtatAvoirAchat().getCode());
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria) {
        super(criteria);
    }

    public AvoirAchatSpecification(AvoirAchatCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
