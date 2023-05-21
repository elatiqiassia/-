package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProduitCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String libelle;
    private String libelleLike;
    private String barcode;
    private String barcodeLike;
    private String description;
    private String descriptionLike;
    private String prixAchatMoyen;
    private String prixAchatMoyenMin;
    private String prixAchatMoyenMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String seuilAlert;
    private String seuilAlertMin;
    private String seuilAlertMax;
    private String photoProduits;
    private String photoProduitsLike;

    private CategorieProduitCriteria categorieProduit ;
    private List<CategorieProduitCriteria> categorieProduits ;
    private UniteMesureCriteria uniteMesure ;
    private List<UniteMesureCriteria> uniteMesures ;
    private MarqueCriteria marque ;
    private List<MarqueCriteria> marques ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;


    public ProduitCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getBarcodeLike(){
        return this.barcodeLike;
    }
    public void setBarcodeLike(String barcodeLike){
        this.barcodeLike = barcodeLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(String prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }   
    public String getPrixAchatMoyenMin(){
        return this.prixAchatMoyenMin;
    }
    public void setPrixAchatMoyenMin(String prixAchatMoyenMin){
        this.prixAchatMoyenMin = prixAchatMoyenMin;
    }
    public String getPrixAchatMoyenMax(){
        return this.prixAchatMoyenMax;
    }
    public void setPrixAchatMoyenMax(String prixAchatMoyenMax){
        this.prixAchatMoyenMax = prixAchatMoyenMax;
    }
      
    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }   
    public String getQuantiteMin(){
        return this.quantiteMin;
    }
    public void setQuantiteMin(String quantiteMin){
        this.quantiteMin = quantiteMin;
    }
    public String getQuantiteMax(){
        return this.quantiteMax;
    }
    public void setQuantiteMax(String quantiteMax){
        this.quantiteMax = quantiteMax;
    }
      
    public String getSeuilAlert(){
        return this.seuilAlert;
    }
    public void setSeuilAlert(String seuilAlert){
        this.seuilAlert = seuilAlert;
    }   
    public String getSeuilAlertMin(){
        return this.seuilAlertMin;
    }
    public void setSeuilAlertMin(String seuilAlertMin){
        this.seuilAlertMin = seuilAlertMin;
    }
    public String getSeuilAlertMax(){
        return this.seuilAlertMax;
    }
    public void setSeuilAlertMax(String seuilAlertMax){
        this.seuilAlertMax = seuilAlertMax;
    }
      
    public String getPhotoProduits(){
        return this.photoProduits;
    }
    public void setPhotoProduits(String photoProduits){
        this.photoProduits = photoProduits;
    }
    public String getPhotoProduitsLike(){
        return this.photoProduitsLike;
    }
    public void setPhotoProduitsLike(String photoProduitsLike){
        this.photoProduitsLike = photoProduitsLike;
    }


    public CategorieProduitCriteria getCategorieProduit(){
        return this.categorieProduit;
    }

    public void setCategorieProduit(CategorieProduitCriteria categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public List<CategorieProduitCriteria> getCategorieProduits(){
        return this.categorieProduits;
    }

    public void setCategorieProduits(List<CategorieProduitCriteria> categorieProduits){
        this.categorieProduits = categorieProduits;
    }
    public UniteMesureCriteria getUniteMesure(){
        return this.uniteMesure;
    }

    public void setUniteMesure(UniteMesureCriteria uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public List<UniteMesureCriteria> getUniteMesures(){
        return this.uniteMesures;
    }

    public void setUniteMesures(List<UniteMesureCriteria> uniteMesures){
        this.uniteMesures = uniteMesures;
    }
    public MarqueCriteria getMarque(){
        return this.marque;
    }

    public void setMarque(MarqueCriteria marque){
        this.marque = marque;
    }
    public List<MarqueCriteria> getMarques(){
        return this.marques;
    }

    public void setMarques(List<MarqueCriteria> marques){
        this.marques = marques;
    }
    public StoreCriteria getStore(){
        return this.store;
    }

    public void setStore(StoreCriteria store){
        this.store = store;
    }
    public List<StoreCriteria> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreCriteria> stores){
        this.stores = stores;
    }
}
