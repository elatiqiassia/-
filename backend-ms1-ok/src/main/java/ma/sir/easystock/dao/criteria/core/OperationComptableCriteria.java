package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OperationComptableCriteria extends  BaseCriteria  {

    private LocalDateTime dateOperationComptable;
    private LocalDateTime dateOperationComptableFrom;
    private LocalDateTime dateOperationComptableTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private CompteComptableCriteria compteComptable ;
    private List<CompteComptableCriteria> compteComptables ;


    public OperationComptableCriteria(){}

    public LocalDateTime getDateOperationComptable(){
        return this.dateOperationComptable;
    }
    public void setDateOperationComptable(LocalDateTime dateOperationComptable){
        this.dateOperationComptable = dateOperationComptable;
    }
    public LocalDateTime getDateOperationComptableFrom(){
        return this.dateOperationComptableFrom;
    }
    public void setDateOperationComptableFrom(LocalDateTime dateOperationComptableFrom){
        this.dateOperationComptableFrom = dateOperationComptableFrom;
    }
    public LocalDateTime getDateOperationComptableTo(){
        return this.dateOperationComptableTo;
    }
    public void setDateOperationComptableTo(LocalDateTime dateOperationComptableTo){
        this.dateOperationComptableTo = dateOperationComptableTo;
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
    public CompteComptableCriteria getCompteComptable(){
        return this.compteComptable;
    }

    public void setCompteComptable(CompteComptableCriteria compteComptable){
        this.compteComptable = compteComptable;
    }
    public List<CompteComptableCriteria> getCompteComptables(){
        return this.compteComptables;
    }

    public void setCompteComptables(List<CompteComptableCriteria> compteComptables){
        this.compteComptables = compteComptables;
    }
}
