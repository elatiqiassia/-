package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AvoirVenteCriteria extends  BaseCriteria  {

    private LocalDateTime dateAvoir;
    private LocalDateTime dateAvoirFrom;
    private LocalDateTime dateAvoirTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private VenteCriteria vente ;
    private List<VenteCriteria> ventes ;
    private EtatAvoirVenteCriteria etatAvoirVente ;
    private List<EtatAvoirVenteCriteria> etatAvoirVentes ;


    public AvoirVenteCriteria(){}

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
    public EtatAvoirVenteCriteria getEtatAvoirVente(){
        return this.etatAvoirVente;
    }

    public void setEtatAvoirVente(EtatAvoirVenteCriteria etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }
    public List<EtatAvoirVenteCriteria> getEtatAvoirVentes(){
        return this.etatAvoirVentes;
    }

    public void setEtatAvoirVentes(List<EtatAvoirVenteCriteria> etatAvoirVentes){
        this.etatAvoirVentes = etatAvoirVentes;
    }
}
