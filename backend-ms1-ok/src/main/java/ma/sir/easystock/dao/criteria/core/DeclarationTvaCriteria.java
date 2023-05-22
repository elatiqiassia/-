package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DeclarationTvaCriteria extends  BaseCriteria  {

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
    private String totalTvaCollecte;
    private String totalTvaCollecteMin;
    private String totalTvaCollecteMax;
    private String totalTvaDue;
    private String totalTvaDueMin;
    private String totalTvaDueMax;
    private String differenceTva;
    private String differenceTvaMin;
    private String differenceTvaMax;
    private String montantTva;
    private String montantTvaMin;
    private String montantTvaMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private TauxRetardTvaCriteria tauxRetardTva ;
    private List<TauxRetardTvaCriteria> tauxRetardTvas ;
    private ComptableTraitantCriteria comptableTraitant ;
    private List<ComptableTraitantCriteria> comptableTraitants ;
    private ComptableValidateurCriteria comptableValidateur ;
    private List<ComptableValidateurCriteria> comptableValidateurs ;


    public DeclarationTvaCriteria(){}

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
      
    public String getTotalTvaCollecte(){
        return this.totalTvaCollecte;
    }
    public void setTotalTvaCollecte(String totalTvaCollecte){
        this.totalTvaCollecte = totalTvaCollecte;
    }   
    public String getTotalTvaCollecteMin(){
        return this.totalTvaCollecteMin;
    }
    public void setTotalTvaCollecteMin(String totalTvaCollecteMin){
        this.totalTvaCollecteMin = totalTvaCollecteMin;
    }
    public String getTotalTvaCollecteMax(){
        return this.totalTvaCollecteMax;
    }
    public void setTotalTvaCollecteMax(String totalTvaCollecteMax){
        this.totalTvaCollecteMax = totalTvaCollecteMax;
    }
      
    public String getTotalTvaDue(){
        return this.totalTvaDue;
    }
    public void setTotalTvaDue(String totalTvaDue){
        this.totalTvaDue = totalTvaDue;
    }   
    public String getTotalTvaDueMin(){
        return this.totalTvaDueMin;
    }
    public void setTotalTvaDueMin(String totalTvaDueMin){
        this.totalTvaDueMin = totalTvaDueMin;
    }
    public String getTotalTvaDueMax(){
        return this.totalTvaDueMax;
    }
    public void setTotalTvaDueMax(String totalTvaDueMax){
        this.totalTvaDueMax = totalTvaDueMax;
    }
      
    public String getDifferenceTva(){
        return this.differenceTva;
    }
    public void setDifferenceTva(String differenceTva){
        this.differenceTva = differenceTva;
    }   
    public String getDifferenceTvaMin(){
        return this.differenceTvaMin;
    }
    public void setDifferenceTvaMin(String differenceTvaMin){
        this.differenceTvaMin = differenceTvaMin;
    }
    public String getDifferenceTvaMax(){
        return this.differenceTvaMax;
    }
    public void setDifferenceTvaMax(String differenceTvaMax){
        this.differenceTvaMax = differenceTvaMax;
    }
      
    public String getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
    }   
    public String getMontantTvaMin(){
        return this.montantTvaMin;
    }
    public void setMontantTvaMin(String montantTvaMin){
        this.montantTvaMin = montantTvaMin;
    }
    public String getMontantTvaMax(){
        return this.montantTvaMax;
    }
    public void setMontantTvaMax(String montantTvaMax){
        this.montantTvaMax = montantTvaMax;
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
    public TauxRetardTvaCriteria getTauxRetardTva(){
        return this.tauxRetardTva;
    }

    public void setTauxRetardTva(TauxRetardTvaCriteria tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
    }
    public List<TauxRetardTvaCriteria> getTauxRetardTvas(){
        return this.tauxRetardTvas;
    }

    public void setTauxRetardTvas(List<TauxRetardTvaCriteria> tauxRetardTvas){
        this.tauxRetardTvas = tauxRetardTvas;
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
