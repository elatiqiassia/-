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
public class AchatDto  extends AuditBaseDto {

    private String reference  ;
    private String dateAchat ;
    private BigDecimal total  ;
    private BigDecimal totalPaye  ;
    private String description  ;

    private FournisseurDto fournisseur ;
    private StoreDto store ;
    private EtatAchatDto etatAchat ;

    private List<AchatItemDto> achatItems ;


    public AchatDto(){
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
    public String getDateAchat(){
        return this.dateAchat;
    }
    public void setDateAchat(String dateAchat){
        this.dateAchat = dateAchat;
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


    public FournisseurDto getFournisseur(){
        return this.fournisseur;
    }

    public void setFournisseur(FournisseurDto fournisseur){
        this.fournisseur = fournisseur;
    }
    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }
    public EtatAchatDto getEtatAchat(){
        return this.etatAchat;
    }

    public void setEtatAchat(EtatAchatDto etatAchat){
        this.etatAchat = etatAchat;
    }



    public List<AchatItemDto> getAchatItems(){
        return this.achatItems;
    }

    public void setAchatItems(List<AchatItemDto> achatItems){
        this.achatItems = achatItems;
    }

}
