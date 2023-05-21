package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class TauxIsCriteria extends  BaseCriteria  {

    private String resultatMin;
    private String resultatMinMin;
    private String resultatMinMax;
    private String resultatMax;
    private String resultatMaxMin;
    private String resultatMaxMax;
    private LocalDateTime dateApplicationMin;
    private LocalDateTime dateApplicationMinFrom;
    private LocalDateTime dateApplicationMinTo;
    private LocalDateTime dateApplicationMax;
    private LocalDateTime dateApplicationMaxFrom;
    private LocalDateTime dateApplicationMaxTo;
    private String pourcentage;
    private String pourcentageMin;
    private String pourcentageMax;



    public TauxIsCriteria(){}

    public String getResultatMin(){
        return this.resultatMin;
    }
    public void setResultatMin(String resultatMin){
        this.resultatMin = resultatMin;
    }   
    public String getResultatMinMin(){
        return this.resultatMinMin;
    }
    public void setResultatMinMin(String resultatMinMin){
        this.resultatMinMin = resultatMinMin;
    }
    public String getResultatMinMax(){
        return this.resultatMinMax;
    }
    public void setResultatMinMax(String resultatMinMax){
        this.resultatMinMax = resultatMinMax;
    }
      
    public String getResultatMax(){
        return this.resultatMax;
    }
    public void setResultatMax(String resultatMax){
        this.resultatMax = resultatMax;
    }   
    public String getResultatMaxMin(){
        return this.resultatMaxMin;
    }
    public void setResultatMaxMin(String resultatMaxMin){
        this.resultatMaxMin = resultatMaxMin;
    }
    public String getResultatMaxMax(){
        return this.resultatMaxMax;
    }
    public void setResultatMaxMax(String resultatMaxMax){
        this.resultatMaxMax = resultatMaxMax;
    }
      
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
    public String getPourcentage(){
        return this.pourcentage;
    }
    public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
    }   
    public String getPourcentageMin(){
        return this.pourcentageMin;
    }
    public void setPourcentageMin(String pourcentageMin){
        this.pourcentageMin = pourcentageMin;
    }
    public String getPourcentageMax(){
        return this.pourcentageMax;
    }
    public void setPourcentageMax(String pourcentageMax){
        this.pourcentageMax = pourcentageMax;
    }
      

}
