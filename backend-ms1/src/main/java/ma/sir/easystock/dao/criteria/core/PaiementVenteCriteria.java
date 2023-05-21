package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementVenteCriteria extends  BaseCriteria  {

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

    private VenteCriteria vente ;
    private List<VenteCriteria> ventes ;
    private ModePaiementCriteria modePaiement ;
    private List<ModePaiementCriteria> modePaiements ;
    private EtatPaiementVenteCriteria etatPaiementVente ;
    private List<EtatPaiementVenteCriteria> etatPaiementVentes ;


    public PaiementVenteCriteria(){}

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


    public VenteCriteria getVente(){
        return this.vente;
    }

    public void setVente(VenteCriteria vente){
        this.vente = vente;
    }
    public List<VenteCriteria> getVentes(){
        return this.ventes;
    }

    public void setVentes(List<VenteCriteria> ventes){
        this.ventes = ventes;
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
    public EtatPaiementVenteCriteria getEtatPaiementVente(){
        return this.etatPaiementVente;
    }

    public void setEtatPaiementVente(EtatPaiementVenteCriteria etatPaiementVente){
        this.etatPaiementVente = etatPaiementVente;
    }
    public List<EtatPaiementVenteCriteria> getEtatPaiementVentes(){
        return this.etatPaiementVentes;
    }

    public void setEtatPaiementVentes(List<EtatPaiementVenteCriteria> etatPaiementVentes){
        this.etatPaiementVentes = etatPaiementVentes;
    }
}
