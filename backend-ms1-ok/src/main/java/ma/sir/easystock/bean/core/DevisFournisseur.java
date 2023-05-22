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
@Table(name = "devis_fournisseur")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="devis_fournisseur_seq",sequenceName="devis_fournisseur_seq",allocationSize=1, initialValue = 1)
public class DevisFournisseur   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateDevis ;
    private BigDecimal total = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Fournisseur fournisseur ;
    

    private List<DevisItemFournisseur> devisItemFournisseurs ;

    public DevisFournisseur(){
        super();
    }

    public DevisFournisseur(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="devis_fournisseur_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(LocalDateTime dateDevis){
        this.dateDevis = dateDevis;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Fournisseur getFournisseur(){
        return this.fournisseur;
    }
    public void setFournisseur(Fournisseur fournisseur){
        this.fournisseur = fournisseur;
    }
    @OneToMany(mappedBy = "devisFournisseur")
    public List<DevisItemFournisseur> getDevisItemFournisseurs(){
        return this.devisItemFournisseurs;
    }
    public void setDevisItemFournisseurs(List<DevisItemFournisseur> devisItemFournisseurs){
        this.devisItemFournisseurs = devisItemFournisseurs;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DevisFournisseur devisFournisseur = (DevisFournisseur) o;
        return id != null && id.equals(devisFournisseur.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

