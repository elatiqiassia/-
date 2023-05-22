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
public class OperationComptableDto  extends AuditBaseDto {

    private String dateOperationComptable ;
    private BigDecimal montant  ;

    private SocieteDto societe ;
    private CompteComptableDto compteComptable ;



    public OperationComptableDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateOperationComptable(){
        return this.dateOperationComptable;
    }
    public void setDateOperationComptable(String dateOperationComptable){
        this.dateOperationComptable = dateOperationComptable;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }
    public CompteComptableDto getCompteComptable(){
        return this.compteComptable;
    }

    public void setCompteComptable(CompteComptableDto compteComptable){
        this.compteComptable = compteComptable;
    }




}
