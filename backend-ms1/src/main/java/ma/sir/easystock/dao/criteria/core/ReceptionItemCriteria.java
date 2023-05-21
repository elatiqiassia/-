package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReceptionItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private MagasinCriteria magasin ;
    private List<MagasinCriteria> magasins ;
    private ReceptionCriteria reception ;
    private List<ReceptionCriteria> receptions ;


    public ReceptionItemCriteria(){}

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
    public ReceptionCriteria getReception(){
        return this.reception;
    }

    public void setReception(ReceptionCriteria reception){
        this.reception = reception;
    }
    public List<ReceptionCriteria> getReceptions(){
        return this.receptions;
    }

    public void setReceptions(List<ReceptionCriteria> receptions){
        this.receptions = receptions;
    }
}
