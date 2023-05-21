package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AvoirAchatItemCriteria extends  BaseCriteria  {

    private String montant;
    private String montantMin;
    private String montantMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private AvoirAchatCriteria avoirAchat ;
    private List<AvoirAchatCriteria> avoirAchats ;


    public AvoirAchatItemCriteria(){}

    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
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
    public AvoirAchatCriteria getAvoirAchat(){
        return this.avoirAchat;
    }

    public void setAvoirAchat(AvoirAchatCriteria avoirAchat){
        this.avoirAchat = avoirAchat;
    }
    public List<AvoirAchatCriteria> getAvoirAchats(){
        return this.avoirAchats;
    }

    public void setAvoirAchats(List<AvoirAchatCriteria> avoirAchats){
        this.avoirAchats = avoirAchats;
    }
}
