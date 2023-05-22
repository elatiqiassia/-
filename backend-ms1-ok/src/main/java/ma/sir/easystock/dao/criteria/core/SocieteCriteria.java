package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SocieteCriteria extends  BaseCriteria  {

    private String ice;
    private String iceLike;
    private String siege;
    private String siegeLike;
    private String dernierAnneePayerIs;
    private String dernierAnneePayerIsMin;
    private String dernierAnneePayerIsMax;
    private String dernierTrimestrePayerIs;
    private String dernierTrimestrePayerIsMin;
    private String dernierTrimestrePayerIsMax;
    private String dernierAnneePayerTva;
    private String dernierAnneePayerTvaMin;
    private String dernierAnneePayerTvaMax;
    private String dernierTrimestrePayerTva;
    private String dernierTrimestrePayerTvaMin;
    private String dernierTrimestrePayerTvaMax;
    private Boolean bloqued;

    private AbonneCriteria abonne ;
    private List<AbonneCriteria> abonnes ;


    public SocieteCriteria(){}

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }

    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }
    public String getSiegeLike(){
        return this.siegeLike;
    }
    public void setSiegeLike(String siegeLike){
        this.siegeLike = siegeLike;
    }

    public String getDernierAnneePayerIs(){
        return this.dernierAnneePayerIs;
    }
    public void setDernierAnneePayerIs(String dernierAnneePayerIs){
        this.dernierAnneePayerIs = dernierAnneePayerIs;
    }   
    public String getDernierAnneePayerIsMin(){
        return this.dernierAnneePayerIsMin;
    }
    public void setDernierAnneePayerIsMin(String dernierAnneePayerIsMin){
        this.dernierAnneePayerIsMin = dernierAnneePayerIsMin;
    }
    public String getDernierAnneePayerIsMax(){
        return this.dernierAnneePayerIsMax;
    }
    public void setDernierAnneePayerIsMax(String dernierAnneePayerIsMax){
        this.dernierAnneePayerIsMax = dernierAnneePayerIsMax;
    }
      
    public String getDernierTrimestrePayerIs(){
        return this.dernierTrimestrePayerIs;
    }
    public void setDernierTrimestrePayerIs(String dernierTrimestrePayerIs){
        this.dernierTrimestrePayerIs = dernierTrimestrePayerIs;
    }   
    public String getDernierTrimestrePayerIsMin(){
        return this.dernierTrimestrePayerIsMin;
    }
    public void setDernierTrimestrePayerIsMin(String dernierTrimestrePayerIsMin){
        this.dernierTrimestrePayerIsMin = dernierTrimestrePayerIsMin;
    }
    public String getDernierTrimestrePayerIsMax(){
        return this.dernierTrimestrePayerIsMax;
    }
    public void setDernierTrimestrePayerIsMax(String dernierTrimestrePayerIsMax){
        this.dernierTrimestrePayerIsMax = dernierTrimestrePayerIsMax;
    }
      
    public String getDernierAnneePayerTva(){
        return this.dernierAnneePayerTva;
    }
    public void setDernierAnneePayerTva(String dernierAnneePayerTva){
        this.dernierAnneePayerTva = dernierAnneePayerTva;
    }   
    public String getDernierAnneePayerTvaMin(){
        return this.dernierAnneePayerTvaMin;
    }
    public void setDernierAnneePayerTvaMin(String dernierAnneePayerTvaMin){
        this.dernierAnneePayerTvaMin = dernierAnneePayerTvaMin;
    }
    public String getDernierAnneePayerTvaMax(){
        return this.dernierAnneePayerTvaMax;
    }
    public void setDernierAnneePayerTvaMax(String dernierAnneePayerTvaMax){
        this.dernierAnneePayerTvaMax = dernierAnneePayerTvaMax;
    }
      
    public String getDernierTrimestrePayerTva(){
        return this.dernierTrimestrePayerTva;
    }
    public void setDernierTrimestrePayerTva(String dernierTrimestrePayerTva){
        this.dernierTrimestrePayerTva = dernierTrimestrePayerTva;
    }   
    public String getDernierTrimestrePayerTvaMin(){
        return this.dernierTrimestrePayerTvaMin;
    }
    public void setDernierTrimestrePayerTvaMin(String dernierTrimestrePayerTvaMin){
        this.dernierTrimestrePayerTvaMin = dernierTrimestrePayerTvaMin;
    }
    public String getDernierTrimestrePayerTvaMax(){
        return this.dernierTrimestrePayerTvaMax;
    }
    public void setDernierTrimestrePayerTvaMax(String dernierTrimestrePayerTvaMax){
        this.dernierTrimestrePayerTvaMax = dernierTrimestrePayerTvaMax;
    }
      
    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }

    public AbonneCriteria getAbonne(){
        return this.abonne;
    }

    public void setAbonne(AbonneCriteria abonne){
        this.abonne = abonne;
    }
    public List<AbonneCriteria> getAbonnes(){
        return this.abonnes;
    }

    public void setAbonnes(List<AbonneCriteria> abonnes){
        this.abonnes = abonnes;
    }
}
