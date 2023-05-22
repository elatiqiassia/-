package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "demande_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_item_seq",sequenceName="demande_item_seq",allocationSize=1, initialValue = 1)
public class DemandeItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal prix = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal quantiteLivre = BigDecimal.ZERO;

    private Produit produit ;
    
    private Demande demande ;
    


    public DemandeItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
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
    public BigDecimal getQuantiteLivre(){
        return this.quantiteLivre;
    }
    public void setQuantiteLivre(BigDecimal quantiteLivre){
        this.quantiteLivre = quantiteLivre;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandeItem demandeItem = (DemandeItem) o;
        return id != null && id.equals(demandeItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

