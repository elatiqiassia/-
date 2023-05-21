package ma.sir.easystock.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "paiement_demande")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_demande_seq",sequenceName="paiement_demande_seq",allocationSize=1, initialValue = 1)
public class PaiementDemande   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime datePaiement ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;
    @Column(columnDefinition = "boolean default false")
    private Boolean chequeVire = false;

    private Demande demande ;
    
    private ModePaiement modePaiement ;
    
    private EtatPaiementDemande etatPaiementDemande ;
    


    public PaiementDemande(){
        super();
    }

    public PaiementDemande(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_demande_seq")
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
    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ModePaiement getModePaiement(){
        return this.modePaiement;
    }
    public void setModePaiement(ModePaiement modePaiement){
        this.modePaiement = modePaiement;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Boolean  getChequeVire(){
        return this.chequeVire;
    }
    public void setChequeVire(Boolean chequeVire){
        this.chequeVire = chequeVire;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatPaiementDemande getEtatPaiementDemande(){
        return this.etatPaiementDemande;
    }
    public void setEtatPaiementDemande(EtatPaiementDemande etatPaiementDemande){
        this.etatPaiementDemande = etatPaiementDemande;
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
        PaiementDemande paiementDemande = (PaiementDemande) o;
        return id != null && id.equals(paiementDemande.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

