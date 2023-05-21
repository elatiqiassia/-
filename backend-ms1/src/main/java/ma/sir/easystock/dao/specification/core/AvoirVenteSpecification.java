package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.AvoirVenteCriteria;
import ma.sir.easystock.bean.core.AvoirVente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AvoirVenteSpecification extends  AbstractSpecification<AvoirVenteCriteria, AvoirVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("dateAvoir", criteria.getDateAvoir(), criteria.getDateAvoirFrom(), criteria.getDateAvoirTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","reference", criteria.getVente()==null?null:criteria.getVente().getReference());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVente()==null?null:criteria.getEtatAvoirVente().getId());
        addPredicateFk("etatAvoirVente","id", criteria.getEtatAvoirVentes());
        addPredicateFk("etatAvoirVente","code", criteria.getEtatAvoirVente()==null?null:criteria.getEtatAvoirVente().getCode());
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria) {
        super(criteria);
    }

    public AvoirVenteSpecification(AvoirVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
