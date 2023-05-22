package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DemandeItemCriteria extends  BaseCriteria  {

    private String prix;
    private String prixMin;
    private String prixMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String quantiteLivre;
    private String quantiteLivreMin;
    private String quantiteLivreMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private DemandeCriteria demande ;
    private List<DemandeCriteria> demandes ;


    public DemandeItemCriteria(){}

    public String getPrix(){
        return this.prix;
    }
    public void setPrix(String prix){
        this.prix = prix;
    }   
    public String getPrixMin(){
        return this.prixMin;
    }
    public void setPrixMin(String prixMin){
        this.prixMin = prixMin;
    }
    public String getPrixMax(){
        return this.prixMax;
    }
    public void setPrixMax(String prixMax){
        this.prixMax = prixMax;
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
      
    public String getQuantiteLivre(){
        return this.quantiteLivre;
    }
    public void setQuantiteLivre(String quantiteLivre){
        this.quantiteLivre = quantiteLivre;
    }   
    public String getQuantiteLivreMin(){
        return this.quantiteLivreMin;
    }
    public void setQuantiteLivreMin(String quantiteLivreMin){
        this.quantiteLivreMin = quantiteLivreMin;
    }
    public String getQuantiteLivreMax(){
        return this.quantiteLivreMax;
    }
    public void setQuantiteLivreMax(String quantiteLivreMax){
        this.quantiteLivreMax = quantiteLivreMax;
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
    public DemandeCriteria getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeCriteria demande){
        this.demande = demande;
    }
    public List<DemandeCriteria> getDemandes(){
        return this.demandes;
    }

    public void setDemandes(List<DemandeCriteria> demandes){
        this.demandes = demandes;
    }
}
