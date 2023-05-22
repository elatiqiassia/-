package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_achat_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_achat_item_seq",sequenceName="avoir_achat_item_seq",allocationSize=1, initialValue = 1)
public class AvoirAchatItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montant = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    
    private AvoirAchat avoirAchat ;
    


    public AvoirAchatItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_achat_item_seq")
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AvoirAchat getAvoirAchat(){
        return this.avoirAchat;
    }
    public void setAvoirAchat(AvoirAchat avoirAchat){
        this.avoirAchat = avoirAchat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchatItem avoirAchatItem = (AvoirAchatItem) o;
        return id != null && id.equals(avoirAchatItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

