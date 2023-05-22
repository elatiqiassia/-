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
public class DevisFournisseurDto  extends AuditBaseDto {

    private String reference  ;
    private String dateDevis ;
    private BigDecimal total  ;
    private String description  ;

    private FournisseurDto fournisseur ;

    private List<DevisItemFournisseurDto> devisItemFournisseurs ;


    public DevisFournisseurDto(){
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
    public String getDateDevis(){
        return this.dateDevis;
    }
    public void setDateDevis(String dateDevis){
        this.dateDevis = dateDevis;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
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



    public List<DevisItemFournisseurDto> getDevisItemFournisseurs(){
        return this.devisItemFournisseurs;
    }

    public void setDevisItemFournisseurs(List<DevisItemFournisseurDto> devisItemFournisseurs){
        this.devisItemFournisseurs = devisItemFournisseurs;
    }

}
