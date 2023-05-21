package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class StockProduitCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;
    private String quantiteDeffecteuse;
    private String quantiteDeffecteuseMin;
    private String quantiteDeffecteuseMax;

    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;


    public StockProduitCriteria(){}

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
      
    public String getQuantiteDeffecteuse(){
        return this.quantiteDeffecteuse;
    }
    public void setQuantiteDeffecteuse(String quantiteDeffecteuse){
        this.quantiteDeffecteuse = quantiteDeffecteuse;
    }   
    public String getQuantiteDeffecteuseMin(){
        return this.quantiteDeffecteuseMin;
    }
    public void setQuantiteDeffecteuseMin(String quantiteDeffecteuseMin){
        this.quantiteDeffecteuseMin = quantiteDeffecteuseMin;
    }
    public String getQuantiteDeffecteuseMax(){
        return this.quantiteDeffecteuseMax;
    }
    public void setQuantiteDeffecteuseMax(String quantiteDeffecteuseMax){
        this.quantiteDeffecteuseMax = quantiteDeffecteuseMax;
    }
      

    public MagasinCriteria getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinCriteria magasin){
        this.magasin = magasin;
    }
    public List<MagasinCriteria> getMagasins(){
        return this.magasins;
    }

    public void setMagasins(List<MagasinCriteria> magasins){
        this.magasins = magasins;
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
}
