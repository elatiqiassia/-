package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceptionDto  extends AuditBaseDto {

    private String reference  ;
    private String dateReception ;
    private String description  ;

    private CommandeDto commande ;
    private EtatReceptionDto etatReception ;

    private List<ReceptionItemDto> receptionItems ;


    public ReceptionDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(String dateReception){
        this.dateReception = dateReception;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public CommandeDto getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeDto commande){
        this.commande = commande;
    }
    public EtatReceptionDto getEtatReception(){
        return this.etatReception;
    }

    public void setEtatReception(EtatReceptionDto etatReception){
        this.etatReception = etatReception;
    }



    public List<ReceptionItemDto> getReceptionItems(){
        return this.receptionItems;
    }

    public void setReceptionItems(List<ReceptionItemDto> receptionItems){
        this.receptionItems = receptionItems;
    }

}
