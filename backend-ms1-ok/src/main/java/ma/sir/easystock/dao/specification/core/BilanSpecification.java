package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.BilanCriteria;
import ma.sir.easystock.bean.core.Bilan;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BilanSpecification extends  AbstractSpecification<BilanCriteria, Bilan>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateBigDecimal("immobilisationsIncorporelles", criteria.getImmobilisationsIncorporelles(), criteria.getImmobilisationsIncorporellesMin(), criteria.getImmobilisationsIncorporellesMax());
        addPredicateBigDecimal("immobilisationsCorporelles", criteria.getImmobilisationsCorporelles(), criteria.getImmobilisationsCorporellesMin(), criteria.getImmobilisationsCorporellesMax());
        addPredicateBigDecimal("immobilisationsFinancieres", criteria.getImmobilisationsFinancieres(), criteria.getImmobilisationsFinancieresMin(), criteria.getImmobilisationsFinancieresMax());
        addPredicateBigDecimal("totalActifImmobolise", criteria.getTotalActifImmobolise(), criteria.getTotalActifImmoboliseMin(), criteria.getTotalActifImmoboliseMax());
        addPredicateBigDecimal("stocks", criteria.getStocks(), criteria.getStocksMin(), criteria.getStocksMax());
        addPredicateBigDecimal("creancesClients", criteria.getCreancesClients(), criteria.getCreancesClientsMin(), criteria.getCreancesClientsMax());
        addPredicateBigDecimal("totalActifCirculant", criteria.getTotalActifCirculant(), criteria.getTotalActifCirculantMin(), criteria.getTotalActifCirculantMax());
        addPredicateBigDecimal("depotEnBanque", criteria.getDepotEnBanque(), criteria.getDepotEnBanqueMin(), criteria.getDepotEnBanqueMax());
        addPredicateBigDecimal("avoirEnCaisse", criteria.getAvoirEnCaisse(), criteria.getAvoirEnCaisseMin(), criteria.getAvoirEnCaisseMax());
        addPredicateBigDecimal("totalTresorieActif", criteria.getTotalTresorieActif(), criteria.getTotalTresorieActifMin(), criteria.getTotalTresorieActifMax());
        addPredicateBigDecimal("totalActif", criteria.getTotalActif(), criteria.getTotalActifMin(), criteria.getTotalActifMax());
        addPredicateBigDecimal("capitalPersonnel", criteria.getCapitalPersonnel(), criteria.getCapitalPersonnelMin(), criteria.getCapitalPersonnelMax());
        addPredicateBigDecimal("emprunts", criteria.getEmprunts(), criteria.getEmpruntsMin(), criteria.getEmpruntsMax());
        addPredicateBigDecimal("resultat", criteria.getResultat(), criteria.getResultatMin(), criteria.getResultatMax());
        addPredicateBigDecimal("totalFinnancementPermanant", criteria.getTotalFinnancementPermanant(), criteria.getTotalFinnancementPermanantMin(), criteria.getTotalFinnancementPermanantMax());
        addPredicateBigDecimal("dettesFournisseurs", criteria.getDettesFournisseurs(), criteria.getDettesFournisseursMin(), criteria.getDettesFournisseursMax());
        addPredicateBigDecimal("autresDettesCirculantes", criteria.getAutresDettesCirculantes(), criteria.getAutresDettesCirculantesMin(), criteria.getAutresDettesCirculantesMax());
        addPredicateBigDecimal("totalPassifCirculant", criteria.getTotalPassifCirculant(), criteria.getTotalPassifCirculantMin(), criteria.getTotalPassifCirculantMax());
        addPredicateBigDecimal("totalPassif", criteria.getTotalPassif(), criteria.getTotalPassifMin(), criteria.getTotalPassifMax());
        addPredicateFk("societe","id", criteria.getSociete()==null?null:criteria.getSociete().getId());
        addPredicateFk("societe","id", criteria.getSocietes());
        addPredicateFk("societe","ice", criteria.getSociete()==null?null:criteria.getSociete().getIce());
    }

    public BilanSpecification(BilanCriteria criteria) {
        super(criteria);
    }

    public BilanSpecification(BilanCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
