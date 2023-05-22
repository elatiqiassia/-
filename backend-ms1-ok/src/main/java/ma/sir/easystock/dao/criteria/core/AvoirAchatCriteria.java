package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AvoirAchatCriteria extends  BaseCriteria  {

    private LocalDateTime dateAvoir;
    private LocalDateTime dateAvoirFrom;
    private LocalDateTime dateAvoirTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private AchatCriteria achat ;
    private List<AchatCriteria> achats ;
    private EtatAvoirAchatCriteria etatAvoirAchat ;
    private List<EtatAvoirAchatCriteria> etatAvoirAchats ;


    public AvoirAchatCriteria(){}

    public LocalDateTime getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(LocalDateTime dateAvoir){
        this.dateAvoir = dateAvoir;
    }
    public LocalDateTime getDateAvoirFrom(){
        return this.dateAvoirFrom;
    }
    public void setDateAvoirFrom(LocalDateTime dateAvoirFrom){
        this.dateAvoirFrom = dateAvoirFrom;
    }
    public LocalDateTime getDateAvoirTo(){
        return this.dateAvoirTo;
    }
    public void setDateAvoirTo(LocalDateTime dateAvoirTo){
        this.dateAvoirTo = dateAvoirTo;
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
      

    public AchatCriteria getAchat(){
        return this.achat;
    }

    public void setAchat(AchatCriteria achat){
        this.achat = achat;
    }
    public List<AchatCriteria> getAchats(){
        return this.achats;
    }

    public void setAchats(List<AchatCriteria> achats){
        this.achats = achats;
    }
    public EtatAvoirAchatCriteria getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }

    public void setEtatAvoirAchat(EtatAvoirAchatCriteria etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }
    public List<EtatAvoirAchatCriteria> getEtatAvoirAchats(){
        return this.etatAvoirAchats;
    }

    public void setEtatAvoirAchats(List<EtatAvoirAchatCriteria> etatAvoirAchats){
        this.etatAvoirAchats = etatAvoirAchats;
    }
}
