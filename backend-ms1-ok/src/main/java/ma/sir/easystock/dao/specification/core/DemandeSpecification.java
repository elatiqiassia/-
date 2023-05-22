package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.DemandeCriteria;
import ma.sir.easystock.bean.core.Demande;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DemandeSpecification extends  AbstractSpecification<DemandeCriteria, Demande>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateCommande", criteria.getDateCommande(), criteria.getDateCommandeFrom(), criteria.getDateCommandeTo());
        addPredicateBigDecimal("totalCheque", criteria.getTotalCheque(), criteria.getTotalChequeMin(), criteria.getTotalChequeMax());
        addPredicateBigDecimal("totalEspece", criteria.getTotalEspece(), criteria.getTotalEspeceMin(), criteria.getTotalEspeceMax());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalePaye", criteria.getTotalePaye(), criteria.getTotalePayeMin(), criteria.getTotalePayeMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("etatDemande","id", criteria.getEtatDemande()==null?null:criteria.getEtatDemande().getId());
        addPredicateFk("etatDemande","id", criteria.getEtatDemandes());
        addPredicateFk("etatDemande","code", criteria.getEtatDemande()==null?null:criteria.getEtatDemande().getCode());
    }

    public DemandeSpecification(DemandeCriteria criteria) {
        super(criteria);
    }

    public DemandeSpecification(DemandeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
