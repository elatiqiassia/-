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
public class AvoirVenteDto  extends AuditBaseDto {

    private String dateAvoir ;
    private BigDecimal montant  ;

    private VenteDto vente ;
    private EtatAvoirVenteDto etatAvoirVente ;

    private List<AvoirVenteItemDto> avoirVenteItems ;


    public AvoirVenteDto(){
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


    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }
    public EtatAvoirVenteDto getEtatAvoirVente(){
        return this.etatAvoirVente;
    }

    public void setEtatAvoirVente(EtatAvoirVenteDto etatAvoirVente){
        this.etatAvoirVente = etatAvoirVente;
    }



    public List<AvoirVenteItemDto> getAvoirVenteItems(){
        return this.avoirVenteItems;
    }

    public void setAvoirVenteItems(List<AvoirVenteItemDto> avoirVenteItems){
        this.avoirVenteItems = avoirVenteItems;
    }

}
