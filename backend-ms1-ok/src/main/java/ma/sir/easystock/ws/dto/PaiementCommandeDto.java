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
public class PaiementCommandeDto  extends AuditBaseDto {

    private String reference  ;
    private String datePaiement ;
    private BigDecimal montant  ;
    private String description  ;
    private Boolean chequeVire  ;

    private CommandeDto commande ;
    private ModePaiementDto modePaiement ;
    private EtatPaiementCommandeDto etatPaiementCommande ;



    public PaiementCommandeDto(){
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
    public String getDatePaiement(){
        return this.datePaiement;
    }
    public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public Boolean getChequeVire(){
        return this.chequeVire;
    }
    public void setChequeVire(Boolean chequeVire){
        this.chequeVire = chequeVire;
    }


    public CommandeDto getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeDto commande){
        this.commande = commande;
    }
    public ModePaiementDto getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementDto modePaiement){
        this.modePaiement = modePaiement;
    }
    public EtatPaiementCommandeDto getEtatPaiementCommande(){
        return this.etatPaiementCommande;
    }

    public void setEtatPaiementCommande(EtatPaiementCommandeDto etatPaiementCommande){
        this.etatPaiementCommande = etatPaiementCommande;
    }




}
