package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementDemandeCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime datePaiement;
    private LocalDateTime datePaiementFrom;
    private LocalDateTime datePaiementTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String description;
    private String descriptionLike;
    private Boolean chequeVire;

    private DemandeCriteria demande ;
    private List<DemandeCriteria> demandes ;
    private ModePaiementCriteria modePaiement ;
    private List<ModePaiementCriteria> modePaiements ;
    private EtatPaiementDemandeCriteria etatPaiementDemande ;
    private List<EtatPaiementDemandeCriteria> etatPaiementDemandes ;


    public PaiementDemandeCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(LocalDateTime datePaiement){
        this.datePaiement = datePaiement;
    }
    public LocalDateTime getDatePaiementFrom(){
        return this.datePaiementFrom;
    }
    public void setDatePaiementFrom(LocalDateTime datePaiementFrom){
        this.datePaiementFrom = datePaiementFrom;
    }
    public LocalDateTime getDatePaiementTo(){
        return this.datePaiementTo;
    }
    public void setDatePaiementTo(LocalDateTime datePaiementTo){
        this.datePaiementTo = datePaiementTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public Boolean getChequeVire(){
        return this.chequeVire;
    }
    public void setChequeVire(Boolean chequeVire){
        this.chequeVire = chequeVire;
    }

    public DemandeCriteria getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeCriteria demande){
        this.demande = demande;
    }
    public List<DemandeCriteria> getDemandes(){
        return this.demandes;
    }

    public void setDemandes(List<DemandeCriteria> demandes){
        this.demandes = demandes;
    }
    public ModePaiementCriteria getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementCriteria modePaiement){
        this.modePaiement = modePaiement;
    }
    public List<ModePaiementCriteria> getModePaiements(){
        return this.modePaiements;
    }

    public void setModePaiements(List<ModePaiementCriteria> modePaiements){
        this.modePaiements = modePaiements;
    }
    public EtatPaiementDemandeCriteria getEtatPaiementDemande(){
        return this.etatPaiementDemande;
    }

    public void setEtatPaiementDemande(EtatPaiementDemandeCriteria etatPaiementDemande){
        this.etatPaiementDemande = etatPaiementDemande;
    }
    public List<EtatPaiementDemandeCriteria> getEtatPaiementDemandes(){
        return this.etatPaiementDemandes;
    }

    public void setEtatPaiementDemandes(List<EtatPaiementDemandeCriteria> etatPaiementDemandes){
        this.etatPaiementDemandes = etatPaiementDemandes;
    }
}
