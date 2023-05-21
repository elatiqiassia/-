package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeDto  extends AuditBaseDto {

    private String reference  ;
    private String dateCommande ;
    private BigDecimal total  ;
    private BigDecimal totalePaye  ;
    private BigDecimal totalPayeCheque  ;
    private BigDecimal totalPayeEspece  ;

    private ClientDto client ;
    private EtatCommandeDto etatCommande ;

    private List<CommandeItemDto> commandeItems ;


    public CommandeDto(){
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
    public String getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(String dateCommande){
        this.dateCommande = dateCommande;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public BigDecimal getTotalePaye(){
        return this.totalePaye;
    }
    public void setTotalePaye(BigDecimal totalePaye){
        this.totalePaye = totalePaye;
    }

    @Log
    public BigDecimal getTotalPayeCheque(){
        return this.totalPayeCheque;
    }
    public void setTotalPayeCheque(BigDecimal totalPayeCheque){
        this.totalPayeCheque = totalPayeCheque;
    }

    @Log
    public BigDecimal getTotalPayeEspece(){
        return this.totalPayeEspece;
    }
    public void setTotalPayeEspece(BigDecimal totalPayeEspece){
        this.totalPayeEspece = totalPayeEspece;
    }


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatCommandeDto getEtatCommande(){
        return this.etatCommande;
    }

    public void setEtatCommande(EtatCommandeDto etatCommande){
        this.etatCommande = etatCommande;
    }



    public List<CommandeItemDto> getCommandeItems(){
        return this.commandeItems;
    }

    public void setCommandeItems(List<CommandeItemDto> commandeItems){
        this.commandeItems = commandeItems;
    }

}
