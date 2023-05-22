package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ReceptionCriteria;
import ma.sir.easystock.bean.core.Reception;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReceptionSpecification extends  AbstractSpecification<ReceptionCriteria, Reception>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateReception", criteria.getDateReception(), criteria.getDateReceptionFrom(), criteria.getDateReceptionTo());
        addPredicateFk("commande","id", criteria.getCommande()==null?null:criteria.getCommande().getId());
        addPredicateFk("commande","id", criteria.getCommandes());
        addPredicateFk("commande","reference", criteria.getCommande()==null?null:criteria.getCommande().getReference());
        addPredicateFk("etatReception","id", criteria.getEtatReception()==null?null:criteria.getEtatReception().getId());
        addPredicateFk("etatReception","id", criteria.getEtatReceptions());
        addPredicateFk("etatReception","code", criteria.getEtatReception()==null?null:criteria.getEtatReception().getCode());
    }

    public ReceptionSpecification(ReceptionCriteria criteria) {
        super(criteria);
    }

    public ReceptionSpecification(ReceptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
