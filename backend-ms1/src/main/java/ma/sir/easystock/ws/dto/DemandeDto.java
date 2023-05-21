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
public class DemandeDto  extends AuditBaseDto {

    private String reference  ;
    private String dateCommande ;
    private BigDecimal totalCheque  ;
    private BigDecimal totalEspece  ;
    private BigDecimal total  ;
    private BigDecimal totalePaye  ;

    private ClientDto client ;
    private EtatDemandeDto etatDemande ;

    private List<DemandeItemDto> demandeItems ;


    public DemandeDto(){
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
    public BigDecimal getTotalCheque(){
        return this.totalCheque;
    }
    public void setTotalCheque(BigDecimal totalCheque){
        this.totalCheque = totalCheque;
    }

    @Log
    public BigDecimal getTotalEspece(){
        return this.totalEspece;
    }
    public void setTotalEspece(BigDecimal totalEspece){
        this.totalEspece = totalEspece;
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


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatDemandeDto getEtatDemande(){
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemandeDto etatDemande){
        this.etatDemande = etatDemande;
    }



    public List<DemandeItemDto> getDemandeItems(){
        return this.demandeItems;
    }

    public void setDemandeItems(List<DemandeItemDto> demandeItems){
        this.demandeItems = demandeItems;
    }

}
