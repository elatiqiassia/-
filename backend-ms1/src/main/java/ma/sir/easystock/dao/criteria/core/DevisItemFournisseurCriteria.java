package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DevisItemFournisseurCriteria extends  BaseCriteria  {

    private String prixUnitaire;
    private String prixUnitaireMin;
    private String prixUnitaireMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String remise;
    private String remiseMin;
    private String remiseMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private DevisFournisseurCriteria devisFournisseur ;
    private List<DevisFournisseurCriteria> devisFournisseurs ;


    public DevisItemFournisseurCriteria(){}

    public String getPrixUnitaire(){
        return this.prixUnitaire;
    }
    public void setPrixUnitaire(String prixUnitaire){
        this.prixUnitaire = prixUnitaire;
    }   
    public String getPrixUnitaireMin(){
        return this.prixUnitaireMin;
    }
    public void setPrixUnitaireMin(String prixUnitaireMin){
        this.prixUnitaireMin = prixUnitaireMin;
    }
    public String getPrixUnitaireMax(){
        return this.prixUnitaireMax;
    }
    public void setPrixUnitaireMax(String prixUnitaireMax){
        this.prixUnitaireMax = prixUnitaireMax;
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
      
    public String getRemise(){
        return this.remise;
    }
    public void setRemise(String remise){
        this.remise = remise;
    }   
    public String getRemiseMin(){
        return this.remiseMin;
    }
    public void setRemiseMin(String remiseMin){
        this.remiseMin = remiseMin;
    }
    public String getRemiseMax(){
        return this.remiseMax;
    }
    public void setRemiseMax(String remiseMax){
        this.remiseMax = remiseMax;
    }
      

    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public DevisFournisseurCriteria getDevisFournisseur(){
        return this.devisFournisseur;
    }

    public void setDevisFournisseur(DevisFournisseurCriteria devisFournisseur){
        this.devisFournisseur = devisFournisseur;
    }
    public List<DevisFournisseurCriteria> getDevisFournisseurs(){
        return this.devisFournisseurs;
    }

    public void setDevisFournisseurs(List<DevisFournisseurCriteria> devisFournisseurs){
        this.devisFournisseurs = devisFournisseurs;
    }
}
