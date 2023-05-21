package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.PaiementLivraisonCriteria;
import ma.sir.easystock.bean.core.PaiementLivraison;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaiementLivraisonSpecification extends  AbstractSpecification<PaiementLivraisonCriteria, PaiementLivraison>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("dateLivraison", criteria.getDateLivraison(), criteria.getDateLivraisonFrom(), criteria.getDateLivraisonTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("livraison","id", criteria.getLivraison()==null?null:criteria.getLivraison().getId());
        addPredicateFk("livraison","id", criteria.getLivraisons());
        addPredicateFk("vente","id", criteria.getVente()==null?null:criteria.getVente().getId());
        addPredicateFk("vente","id", criteria.getVentes());
        addPredicateFk("vente","reference", criteria.getVente()==null?null:criteria.getVente().getReference());
        addPredicateFk("modePaiement","id", criteria.getModePaiement()==null?null:criteria.getModePaiement().getId());
        addPredicateFk("modePaiement","id", criteria.getModePaiements());
        addPredicateFk("modePaiement","code", criteria.getModePaiement()==null?null:criteria.getModePaiement().getCode());
        addPredicateFk("etatPaiementLivraison","id", criteria.getEtatPaiementLivraison()==null?null:criteria.getEtatPaiementLivraison().getId());
        addPredicateFk("etatPaiementLivraison","id", criteria.getEtatPaiementLivraisons());
        addPredicateFk("etatPaiementLivraison","code", criteria.getEtatPaiementLivraison()==null?null:criteria.getEtatPaiementLivraison().getCode());
    }

    public PaiementLivraisonSpecification(PaiementLivraisonCriteria criteria) {
        super(criteria);
    }

    public PaiementLivraisonSpecification(PaiementLivraisonCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
