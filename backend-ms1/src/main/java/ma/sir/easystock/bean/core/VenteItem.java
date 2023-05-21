package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "vente_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vente_item_seq",sequenceName="vente_item_seq",allocationSize=1, initialValue = 1)
public class VenteItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal prixUnitaire = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal remise = BigDecimal.ZERO;
    private BigDecimal quantiteAvoir = BigDecimal.ZERO;

    private Produit produit ;
    
    private Vente vente ;
    


    public VenteItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vente_item_seq")
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
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VenteItem venteItem = (VenteItem) o;
        return id != null && id.equals(venteItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

