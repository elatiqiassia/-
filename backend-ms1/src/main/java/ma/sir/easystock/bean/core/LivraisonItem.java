package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "livraison_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_item_seq",sequenceName="livraison_item_seq",allocationSize=1, initialValue = 1)
public class LivraisonItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    
    private Magasin magasin ;
    
    private Livraison livraison ;
    


    public LivraisonItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="livraison_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Magasin getMagasin(){
        return this.magasin;
    }
    public void setMagasin(Magasin magasin){
        this.magasin = magasin;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Livraison getLivraison(){
        return this.livraison;
    }
    public void setLivraison(Livraison livraison){
        this.livraison = livraison;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivraisonItem livraisonItem = (LivraisonItem) o;
        return id != null && id.equals(livraisonItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

