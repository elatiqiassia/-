package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "stock_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stock_produit_seq",sequenceName="stock_produit_seq",allocationSize=1, initialValue = 1)
public class StockProduit   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal quantiteDeffecteuse = BigDecimal.ZERO;

    private Magasin magasin ;
    
    private Produit produit ;
    


    public StockProduit(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="stock_produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Magasin getMagasin(){
        return this.magasin;
    }
    public void setMagasin(Magasin magasin){
        this.magasin = magasin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Produit getProduit(){
        return this.produit;
    }
    public void setProduit(Produit produit){
        this.produit = produit;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getQuantiteDeffecteuse(){
        return this.quantiteDeffecteuse;
    }
    public void setQuantiteDeffecteuse(BigDecimal quantiteDeffecteuse){
        this.quantiteDeffecteuse = quantiteDeffecteuse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockProduit stockProduit = (StockProduit) o;
        return id != null && id.equals(stockProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

