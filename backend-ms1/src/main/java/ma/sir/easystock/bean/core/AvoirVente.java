package ma.sir.easystock.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_vente")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_vente_seq",sequenceName="avoir_vente_seq",allocationSize=1, initialValue = 1)
public class AvoirVente   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateAvoir ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Vente vente ;
    
    private EtatAvoirVente etatAvoirVente ;
    

    private List<AvoirVenteItem> avoirVenteItems ;

    public AvoirVente(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_vente_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(LocalDateTime dateAvoir){
        this.dateAvoir = dateAvoir;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
    }
    @OneToMany(mappedBy = "avoirVente")
    public List<AvoirVenteItem> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }
    public void setAvoirVenteItems(List<AvoirVenteItem> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatAvoirVente getEtatAvoirVente(){
        return this.etatAvoirVente;
    }
    public void setEtatAvoirVente(EtatAvoirVente etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirVente avoirVente = (AvoirVente) o;
        return id != null && id.equals(avoirVente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

