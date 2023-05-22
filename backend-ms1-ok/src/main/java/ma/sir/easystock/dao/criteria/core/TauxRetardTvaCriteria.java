package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TauxRetardTvaCriteria extends  BaseCriteria  {

    private LocalDateTime dateApplicationMin;
    private LocalDateTime dateApplicationMinFrom;
    private LocalDateTime dateApplicationMinTo;
    private LocalDateTime dateApplicationMax;
    private LocalDateTime dateApplicationMaxFrom;
    private LocalDateTime dateApplicationMaxTo;
    private String montant;
    private String montantMin;
    private String montantMax;



    public TauxRetardTvaCriteria(){}

    public LocalDateTime getDateApplicationMin(){
        return this.dateApplicationMin;
    }
    public void setDateApplicationMin(LocalDateTime dateApplicationMin){
        this.dateApplicationMin = dateApplicationMin;
    }
    public LocalDateTime getDateApplicationMinFrom(){
        return this.dateApplicationMinFrom;
    }
    public void setDateApplicationMinFrom(LocalDateTime dateApplicationMinFrom){
        this.dateApplicationMinFrom = dateApplicationMinFrom;
    }
    public LocalDateTime getDateApplicationMinTo(){
        return this.dateApplicationMinTo;
    }
    public void setDateApplicationMinTo(LocalDateTime dateApplicationMinTo){
        this.dateApplicationMinTo = dateApplicationMinTo;
    }
    public LocalDateTime getDateApplicationMax(){
        return this.dateApplicationMax;
    }
    public void setDateApplicationMax(LocalDateTime dateApplicationMax){
        this.dateApplicationMax = dateApplicationMax;
    }
    public LocalDateTime getDateApplicationMaxFrom(){
        return this.dateApplicationMaxFrom;
    }
    public void setDateApplicationMaxFrom(LocalDateTime dateApplicationMaxFrom){
        this.dateApplicationMaxFrom = dateApplicationMaxFrom;
    }
    public LocalDateTime getDateApplicationMaxTo(){
        return this.dateApplicationMaxTo;
    }
    public void setDateApplicationMaxTo(LocalDateTime dateApplicationMaxTo){
        this.dateApplicationMaxTo = dateApplicationMaxTo;
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
      

}
