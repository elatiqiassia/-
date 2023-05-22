package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class LivraisonItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private LivraisonCriteria livraison ;
    private List<LivraisonCriteria> livraisons ;


    public LivraisonItemCriteria(){}

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
    public LivraisonCriteria getLivraison(){
        return this.livraison;
    }

    public void setLivraison(LivraisonCriteria livraison){
        this.livraison = livraison;
    }
    public List<LivraisonCriteria> getLivraisons(){
        return this.livraisons;
    }

    public void setLivraisons(List<LivraisonCriteria> livraisons){
        this.livraisons = livraisons;
    }
}
