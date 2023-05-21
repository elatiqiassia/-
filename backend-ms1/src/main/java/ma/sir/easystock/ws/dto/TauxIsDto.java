package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TauxIsDto  extends AuditBaseDto {

    private BigDecimal resultatMin  ;
    private BigDecimal resultatMax  ;
    private String dateApplicationMin ;
    private String dateApplicationMax ;
    private BigDecimal pourcentage  ;




    public TauxIsDto(){
        super();
    }



    @Log
    public BigDecimal getResultatMin(){
        return this.resultatMin;
    }
    public void setResultatMin(BigDecimal resultatMin){
        this.resultatMin = resultatMin;
    }

    @Log
    public BigDecimal getResultatMax(){
        return this.resultatMax;
    }
    public void setResultatMax(BigDecimal resultatMax){
        this.resultatMax = resultatMax;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateApplicationMin(){
        return this.dateApplicationMin;
    }
    public void setDateApplicationMin(String dateApplicationMin){
        this.dateApplicationMin = dateApplicationMin;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateApplicationMax(){
        return this.dateApplicationMax;
    }
    public void setDateApplicationMax(String dateApplicationMax){
        this.dateApplicationMax = dateApplicationMax;
    }

    @Log
    public BigDecimal getPourcentage(){
        return this.pourcentage;
    }
    public void setPourcentage(BigDecimal pourcentage){
        this.pourcentage = pourcentage;
    }






}
