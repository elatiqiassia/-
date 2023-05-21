package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaiementLivraisonCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateLivraison;
    private LocalDateTime dateLivraisonFrom;
    private LocalDateTime dateLivraisonTo;
    private String montant;
    private String montantMin;
    private String montantMax;
    private String description;
    private String descriptionLike;

    private LivraisonCriteria livraison ;
    private List<LivraisonCriteria> livraisons ;
    private VenteCriteria vente ;
    private List<VenteCriteria> ventes ;
    private ModePaiementCriteria modePaiement ;
    private List<ModePaiementCriteria> modePaiements ;
    private EtatPaiementLivraisonCriteria etatPaiementLivraison ;
    private List<EtatPaiementLivraisonCriteria> etatPaiementLivraisons ;


    public PaiementLivraisonCriteria(){}

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

    public LocalDateTime getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(LocalDateTime dateLivraison){
        this.dateLivraison = dateLivraison;
    }
    public LocalDateTime getDateLivraisonFrom(){
        return this.dateLivraisonFrom;
    }
    public void setDateLivraisonFrom(LocalDateTime dateLivraisonFrom){
        this.dateLivraisonFrom = dateLivraisonFrom;
    }
    public LocalDateTime getDateLivraisonTo(){
        return this.dateLivraisonTo;
    }
    public void setDateLivraisonTo(LocalDateTime dateLivraisonTo){
        this.dateLivraisonTo = dateLivraisonTo;
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


    public LivraisonCriteria getLivraison(){
        return this.livraison;
    }

    public void setLivraison(LivraisonCriteria livraison){
        this.livraison = livraison;
    }
    public List<LivraisonCriteria> getLivraisons(){
        return this.livraisons;
    }

    public void setLivraisons(List<LivraisonCriteria> livraisons){
        this.livraisons = livraisons;
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
    public EtatPaiementLivraisonCriteria getEtatPaiementLivraison(){
        return this.etatPaiementLivraison;
    }

    public void setEtatPaiementLivraison(EtatPaiementLivraisonCriteria etatPaiementLivraison){
        this.etatPaiementLivraison = etatPaiementLivraison;
    }
    public List<EtatPaiementLivraisonCriteria> getEtatPaiementLivraisons(){
        return this.etatPaiementLivraisons;
    }

    public void setEtatPaiementLivraisons(List<EtatPaiementLivraisonCriteria> etatPaiementLivraisons){
        this.etatPaiementLivraisons = etatPaiementLivraisons;
    }
}
