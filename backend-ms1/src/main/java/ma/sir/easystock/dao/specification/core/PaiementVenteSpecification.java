package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.PaiementVenteCriteria;
import ma.sir.easystock.bean.core.PaiementVente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementVenteSpecification extends  AbstractSpecification<PaiementVenteCriteria, PaiementVente>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("datePaiement", criteria.getDatePaiement(), criteria.getDatePaiementFrom(), criteria.getDatePaiementTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","reference", criteria.getVente()==null?null:criteria.getVente().getReference());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("etatPaiementVente","id", criteria.getEtatPaiementVente()==null?null:criteria.getEtatPaiementVente().getId());
        addPredicateFk("etatPaiementVente","id", criteria.getEtatPaiementVentes());
        addPredicateFk("etatPaiementVente","code", criteria.getEtatPaiementVente()==null?null:criteria.getEtatPaiementVente().getCode());
    }

    public PaiementVenteSpecification(PaiementVenteCriteria criteria) {
        super(criteria);
    }

    public PaiementVenteSpecification(PaiementVenteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
