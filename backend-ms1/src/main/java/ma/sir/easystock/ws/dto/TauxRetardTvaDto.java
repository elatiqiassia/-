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
public class TauxRetardTvaDto  extends AuditBaseDto {

    private String dateApplicationMin ;
    private String dateApplicationMax ;
    private BigDecimal montant  ;




    public TauxRetardTvaDto(){
        super();
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
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }






}
