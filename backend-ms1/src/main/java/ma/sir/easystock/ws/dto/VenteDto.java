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
public class VenteDto  extends AuditBaseDto {

    private String reference  ;
    private String dateVente ;
    private BigDecimal total  ;
    private BigDecimal totalPaye  ;
    private String description  ;

    private StoreDto store ;
    private ClientDto client ;
    private EtatVenteDto etatVente ;

    private List<VenteItemDto> venteItems ;


    public VenteDto(){
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
    public String getDateVente(){
        return this.dateVente;
    }
    public void setDateVente(String dateVente){
        this.dateVente = dateVente;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public BigDecimal getTotalPaye(){
        return this.totalPaye;
    }
    public void setTotalPaye(BigDecimal totalPaye){
        this.totalPaye = totalPaye;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public EtatVenteDto getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteDto etatVente){
        this.etatVente = etatVente;
    }



    public List<VenteItemDto> getVenteItems(){
        return this.venteItems;
    }

    public void setVenteItems(List<VenteItemDto> venteItems){
        this.venteItems = venteItems;
    }

}
