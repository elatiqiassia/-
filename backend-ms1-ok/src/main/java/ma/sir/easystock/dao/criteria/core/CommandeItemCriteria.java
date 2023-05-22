package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CommandeItemCriteria extends  BaseCriteria  {

    private String prix;
    private String prixMin;
    private String prixMax;
    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String quantiteReceptionne;
    private String quantiteReceptionneMin;
    private String quantiteReceptionneMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private CommandeCriteria commande ;
    private List<CommandeCriteria> commandes ;


    public CommandeItemCriteria(){}

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
      
    public String getQuantiteReceptionne(){
        return this.quantiteReceptionne;
    }
    public void setQuantiteReceptionne(String quantiteReceptionne){
        this.quantiteReceptionne = quantiteReceptionne;
    }   
    public String getQuantiteReceptionneMin(){
        return this.quantiteReceptionneMin;
    }
    public void setQuantiteReceptionneMin(String quantiteReceptionneMin){
        this.quantiteReceptionneMin = quantiteReceptionneMin;
    }
    public String getQuantiteReceptionneMax(){
        return this.quantiteReceptionneMax;
    }
    public void setQuantiteReceptionneMax(String quantiteReceptionneMax){
        this.quantiteReceptionneMax = quantiteReceptionneMax;
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
    public CommandeCriteria getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeCriteria commande){
        this.commande = commande;
    }
    public List<CommandeCriteria> getCommandes(){
        return this.commandes;
    }

    public void setCommandes(List<CommandeCriteria> commandes){
        this.commandes = commandes;
    }
}
