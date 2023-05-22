package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "reception_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reception_item_seq",sequenceName="reception_item_seq",allocationSize=1, initialValue = 1)
public class ReceptionItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    
    private Magasin magasin ;
    
    private Reception reception ;
    


    public ReceptionItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="reception_item_seq")
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
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Magasin getMagasin(){
        return this.magasin;
    }
    public void setMagasin(Magasin magasin){
        this.magasin = magasin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Reception getReception(){
        return this.reception;
    }
    public void setReception(Reception reception){
        this.reception = reception;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceptionItem receptionItem = (ReceptionItem) o;
        return id != null && id.equals(receptionItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

