package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_vente_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_vente_item_seq",sequenceName="avoir_vente_item_seq",allocationSize=1, initialValue = 1)
public class AvoirVenteItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal montantAvoir = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;

    private Produit produit ;
    
    private AvoirVente avoirVente ;
    


    public AvoirVenteItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_vente_item_seq")
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
    public BigDecimal getMontantAvoir(){
        return this.montantAvoir;
    }
    public void setMontantAvoir(BigDecimal montantAvoir){
        this.montantAvoir = montantAvoir;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AvoirVente getAvoirVente(){
        return this.avoirVente;
    }
    public void setAvoirVente(AvoirVente avoirVente){
        this.avoirVente = avoirVente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVenteItem avoirVenteItem = (AvoirVenteItem) o;
        return id != null && id.equals(avoirVenteItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

