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
@Table(name = "paiement_livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="paiement_livraison_seq",sequenceName="paiement_livraison_seq",allocationSize=1, initialValue = 1)
public class PaiementLivraison   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateLivraison ;
    private BigDecimal montant = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Livraison livraison ;
    
    private Vente vente ;
    
    private ModePaiement modePaiement ;
    
    private EtatPaiementLivraison etatPaiementLivraison ;
    


    public PaiementLivraison(){
        super();
    }

    public PaiementLivraison(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_livraison_seq")
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
    public LocalDateTime getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(LocalDateTime dateLivraison){
        this.dateLivraison = dateLivraison;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Livraison getLivraison(){
        return this.livraison;
    }
    public void setLivraison(Livraison livraison){
        this.livraison = livraison;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Vente getVente(){
        return this.vente;
    }
    public void setVente(Vente vente){
        this.vente = vente;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatPaiementLivraison getEtatPaiementLivraison(){
        return this.etatPaiementLivraison;
    }
    public void setEtatPaiementLivraison(EtatPaiementLivraison etatPaiementLivraison){
        this.etatPaiementLivraison = etatPaiementLivraison;
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
        PaiementLivraison paiementLivraison = (PaiementLivraison) o;
        return id != null && id.equals(paiementLivraison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

