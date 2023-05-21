package  ma.sir.easystock.dao.specification.core;

import ma.sir.easystock.zynerator.specification.AbstractSpecification;
import ma.sir.easystock.dao.criteria.core.ProduitCriteria;
import ma.sir.easystock.bean.core.Produit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProduitSpecification extends  AbstractSpecification<ProduitCriteria, Produit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("barcode", criteria.getBarcode(),criteria.getBarcodeLike());
        addPredicate("description", criteria.getDescription(),criteria.getDescriptionLike());
        addPredicateBigDecimal("prixAchatMoyen", criteria.getPrixAchatMoyen(), criteria.getPrixAchatMoyenMin(), criteria.getPrixAchatMoyenMax());
        addPredicateBigDecimal("quantite", criteria.getQuantite(), criteria.getQuantiteMin(), criteria.getQuantiteMax());
        addPredicateBigDecimal("seuilAlert", criteria.getSeuilAlert(), criteria.getSeuilAlertMin(), criteria.getSeuilAlertMax());
        addPredicate("photoProduits", criteria.getPhotoProduits(),criteria.getPhotoProduitsLike());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduit()==null?null:criteria.getCategorieProduit().getId());
        addPredicateFk("categorieProduit","id", criteria.getCategorieProduits());
        addPredicateFk("categorieProduit","reference", criteria.getCategorieProduit()==null?null:criteria.getCategorieProduit().getReference());
        addPredicateFk("uniteMesure","id", criteria.getUniteMesure()==null?null:criteria.getUniteMesure().getId());
        addPredicateFk("uniteMesure","id", criteria.getUniteMesures());
        addPredicateFk("uniteMesure","code", criteria.getUniteMesure()==null?null:criteria.getUniteMesure().getCode());
        addPredicateFk("marque","id", criteria.getMarque()==null?null:criteria.getMarque().getId());
        addPredicateFk("marque","id", criteria.getMarques());
        addPredicateFk("marque","code", criteria.getMarque()==null?null:criteria.getMarque().getCode());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
    }

    public ProduitSpecification(ProduitCriteria criteria) {
        super(criteria);
    }

    public ProduitSpecification(ProduitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
