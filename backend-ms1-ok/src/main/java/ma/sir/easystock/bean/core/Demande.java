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
@Table(name = "demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demande_seq",sequenceName="demande_seq",allocationSize=1, initialValue = 1)
public class Demande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateCommande ;
    private BigDecimal totalCheque = BigDecimal.ZERO;
    private BigDecimal totalEspece = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalePaye = BigDecimal.ZERO;

    private Client client ;
    
    private EtatDemande etatDemande ;
    

    private List<DemandeItem> demandeItems ;

    public Demande(){
        super();
    }

    public Demande(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demande_seq")
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
    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    public BigDecimal getTotalCheque(){
        return this.totalCheque;
    }
    public void setTotalCheque(BigDecimal totalCheque){
        this.totalCheque = totalCheque;
    }
    public BigDecimal getTotalEspece(){
        return this.totalEspece;
    }
    public void setTotalEspece(BigDecimal totalEspece){
        this.totalEspece = totalEspece;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public BigDecimal getTotalePaye(){
        return this.totalePaye;
    }
    public void setTotalePaye(BigDecimal totalePaye){
        this.totalePaye = totalePaye;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "demande")
    public List<DemandeItem> getDemandeItems(){
        return this.demandeItems;
    }
    public void setDemandeItems(List<DemandeItem> demandeItems){
        this.demandeItems = demandeItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatDemande getEtatDemande(){
        return this.etatDemande;
    }
    public void setEtatDemande(EtatDemande etatDemande){
        this.etatDemande = etatDemande;
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
        Demande demande = (Demande) o;
        return id != null && id.equals(demande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

