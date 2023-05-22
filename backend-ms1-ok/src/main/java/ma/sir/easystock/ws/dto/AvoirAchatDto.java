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
public class AvoirAchatDto  extends AuditBaseDto {

    private String dateAvoir ;
    private BigDecimal montant  ;

    private AchatDto achat ;
    private EtatAvoirAchatDto etatAvoirAchat ;

    private List<AvoirAchatItemDto> avoirAchatItems ;


    public AvoirAchatDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(String dateAvoir){
        this.dateAvoir = dateAvoir;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public AchatDto getAchat(){
        return this.achat;
    }

    public void setAchat(AchatDto achat){
        this.achat = achat;
    }
    public EtatAvoirAchatDto getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }

    public void setEtatAvoirAchat(EtatAvoirAchatDto etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }



    public List<AvoirAchatItemDto> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }

    public void setAvoirAchatItems(List<AvoirAchatItemDto> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }

}
