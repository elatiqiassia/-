package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DeclarationIsCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateDeclaration;
    private LocalDateTime dateDeclarationFrom;
    private LocalDateTime dateDeclarationTo;
    private String trimistre;
    private String trimistreMin;
    private String trimistreMax;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private String totalCharge;
    private String totalChargeMin;
    private String totalChargeMax;
    private String totalProduit;
    private String totalProduitMin;
    private String totalProduitMax;
    private String resultatAvantImpot;
    private String resultatAvantImpotMin;
    private String resultatAvantImpotMax;
    private String montantImpot;
    private String montantImpotMin;
    private String montantImpotMax;
    private String resultatApresImpot;
    private String resultatApresImpotMin;
    private String resultatApresImpotMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private TauxIsCriteria tauxIs ;
    private List<TauxIsCriteria> tauxIss ;
    private ComptableTraitantCriteria comptableTraitant ;
    private List<ComptableTraitantCriteria> comptableTraitants ;
    private ComptableValidateurCriteria comptableValidateur ;
    private List<ComptableValidateurCriteria> comptableValidateurs ;


    public DeclarationIsCriteria(){}

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

    public LocalDateTime getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(LocalDateTime dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }
    public LocalDateTime getDateDeclarationFrom(){
        return this.dateDeclarationFrom;
    }
    public void setDateDeclarationFrom(LocalDateTime dateDeclarationFrom){
        this.dateDeclarationFrom = dateDeclarationFrom;
    }
    public LocalDateTime getDateDeclarationTo(){
        return this.dateDeclarationTo;
    }
    public void setDateDeclarationTo(LocalDateTime dateDeclarationTo){
        this.dateDeclarationTo = dateDeclarationTo;
    }
    public String getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(String trimistre){
        this.trimistre = trimistre;
    }   
    public String getTrimistreMin(){
        return this.trimistreMin;
    }
    public void setTrimistreMin(String trimistreMin){
        this.trimistreMin = trimistreMin;
    }
    public String getTrimistreMax(){
        return this.trimistreMax;
    }
    public void setTrimistreMax(String trimistreMax){
        this.trimistreMax = trimistreMax;
    }
      
    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public String getTotalCharge(){
        return this.totalCharge;
    }
    public void setTotalCharge(String totalCharge){
        this.totalCharge = totalCharge;
    }   
    public String getTotalChargeMin(){
        return this.totalChargeMin;
    }
    public void setTotalChargeMin(String totalChargeMin){
        this.totalChargeMin = totalChargeMin;
    }
    public String getTotalChargeMax(){
        return this.totalChargeMax;
    }
    public void setTotalChargeMax(String totalChargeMax){
        this.totalChargeMax = totalChargeMax;
    }
      
    public String getTotalProduit(){
        return this.totalProduit;
    }
    public void setTotalProduit(String totalProduit){
        this.totalProduit = totalProduit;
    }   
    public String getTotalProduitMin(){
        return this.totalProduitMin;
    }
    public void setTotalProduitMin(String totalProduitMin){
        this.totalProduitMin = totalProduitMin;
    }
    public String getTotalProduitMax(){
        return this.totalProduitMax;
    }
    public void setTotalProduitMax(String totalProduitMax){
        this.totalProduitMax = totalProduitMax;
    }
      
    public String getResultatAvantImpot(){
        return this.resultatAvantImpot;
    }
    public void setResultatAvantImpot(String resultatAvantImpot){
        this.resultatAvantImpot = resultatAvantImpot;
    }   
    public String getResultatAvantImpotMin(){
        return this.resultatAvantImpotMin;
    }
    public void setResultatAvantImpotMin(String resultatAvantImpotMin){
        this.resultatAvantImpotMin = resultatAvantImpotMin;
    }
    public String getResultatAvantImpotMax(){
        return this.resultatAvantImpotMax;
    }
    public void setResultatAvantImpotMax(String resultatAvantImpotMax){
        this.resultatAvantImpotMax = resultatAvantImpotMax;
    }
      
    public String getMontantImpot(){
        return this.montantImpot;
    }
    public void setMontantImpot(String montantImpot){
        this.montantImpot = montantImpot;
    }   
    public String getMontantImpotMin(){
        return this.montantImpotMin;
    }
    public void setMontantImpotMin(String montantImpotMin){
        this.montantImpotMin = montantImpotMin;
    }
    public String getMontantImpotMax(){
        return this.montantImpotMax;
    }
    public void setMontantImpotMax(String montantImpotMax){
        this.montantImpotMax = montantImpotMax;
    }
      
    public String getResultatApresImpot(){
        return this.resultatApresImpot;
    }
    public void setResultatApresImpot(String resultatApresImpot){
        this.resultatApresImpot = resultatApresImpot;
    }   
    public String getResultatApresImpotMin(){
        return this.resultatApresImpotMin;
    }
    public void setResultatApresImpotMin(String resultatApresImpotMin){
        this.resultatApresImpotMin = resultatApresImpotMin;
    }
    public String getResultatApresImpotMax(){
        return this.resultatApresImpotMax;
    }
    public void setResultatApresImpotMax(String resultatApresImpotMax){
        this.resultatApresImpotMax = resultatApresImpotMax;
    }
      

    public SocieteCriteria getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteCriteria societe){
        this.societe = societe;
    }
    public List<SocieteCriteria> getSocietes(){
        return this.societes;
    }

    public void setSocietes(List<SocieteCriteria> societes){
        this.societes = societes;
    }
    public TauxIsCriteria getTauxIs(){
        return this.tauxIs;
    }

    public void setTauxIs(TauxIsCriteria tauxIs){
        this.tauxIs = tauxIs;
    }
    public List<TauxIsCriteria> getTauxIss(){
        return this.tauxIss;
    }

    public void setTauxIss(List<TauxIsCriteria> tauxIss){
        this.tauxIss = tauxIss;
    }
    public ComptableTraitantCriteria getComptableTraitant(){
        return this.comptableTraitant;
    }

    public void setComptableTraitant(ComptableTraitantCriteria comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public List<ComptableTraitantCriteria> getComptableTraitants(){
        return this.comptableTraitants;
    }

    public void setComptableTraitants(List<ComptableTraitantCriteria> comptableTraitants){
        this.comptableTraitants = comptableTraitants;
    }
    public ComptableValidateurCriteria getComptableValidateur(){
        return this.comptableValidateur;
    }

    public void setComptableValidateur(ComptableValidateurCriteria comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }
    public List<ComptableValidateurCriteria> getComptableValidateurs(){
        return this.comptableValidateurs;
    }

    public void setComptableValidateurs(List<ComptableValidateurCriteria> comptableValidateurs){
        this.comptableValidateurs = comptableValidateurs;
    }
}
