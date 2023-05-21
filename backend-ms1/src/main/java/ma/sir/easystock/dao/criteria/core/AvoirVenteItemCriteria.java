package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AvoirVenteItemCriteria extends  BaseCriteria  {

    private String montantAvoir;
    private String montantAvoirMin;
    private String montantAvoirMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private AvoirVenteCriteria avoirVente ;
    private List<AvoirVenteCriteria> avoirVentes ;


    public AvoirVenteItemCriteria(){}

    public String getMontantAvoir(){
        return this.montantAvoir;
    }
    public void setMontantAvoir(String montantAvoir){
        this.montantAvoir = montantAvoir;
    }   
    public String getMontantAvoirMin(){
        return this.montantAvoirMin;
    }
    public void setMontantAvoirMin(String montantAvoirMin){
        this.montantAvoirMin = montantAvoirMin;
    }
    public String getMontantAvoirMax(){
        return this.montantAvoirMax;
    }
    public void setMontantAvoirMax(String montantAvoirMax){
        this.montantAvoirMax = montantAvoirMax;
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
    public AvoirVenteCriteria getAvoirVente(){
        return this.avoirVente;
    }

    public void setAvoirVente(AvoirVenteCriteria avoirVente){
        this.avoirVente = avoirVente;
    }
    public List<AvoirVenteCriteria> getAvoirVentes(){
        return this.avoirVentes;
    }

    public void setAvoirVentes(List<AvoirVenteCriteria> avoirVentes){
        this.avoirVentes = avoirVentes;
    }
}
