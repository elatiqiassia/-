package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "devis_item_fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="devis_item_fournisseur_seq",sequenceName="devis_item_fournisseur_seq",allocationSize=1, initialValue = 1)
public class DevisItemFournisseur   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal prixUnitaire = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;

    private Produit produit ;
    
    private DevisFournisseur devisFournisseur ;
    


    public DevisItemFournisseur(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="devis_item_fournisseur_seq")
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
    public BigDecimal getPrixUnitaire(){
        return this.prixUnitaire;
    }
    public void setPrixUnitaire(BigDecimal prixUnitaire){
        this.prixUnitaire = prixUnitaire;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DevisFournisseur getDevisFournisseur(){
        return this.devisFournisseur;
    }
    public void setDevisFournisseur(DevisFournisseur devisFournisseur){
        this.devisFournisseur = devisFournisseur;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevisItemFournisseur devisItemFournisseur = (DevisItemFournisseur) o;
        return id != null && id.equals(devisItemFournisseur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

