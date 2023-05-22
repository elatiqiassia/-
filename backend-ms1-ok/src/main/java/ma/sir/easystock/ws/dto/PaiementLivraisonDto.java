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
public class PaiementLivraisonDto  extends AuditBaseDto {

    private String reference  ;
    private String dateLivraison ;
    private BigDecimal montant  ;
    private String description  ;

    private LivraisonDto livraison ;
    private VenteDto vente ;
    private ModePaiementDto modePaiement ;
    private EtatPaiementLivraisonDto etatPaiementLivraison ;



    public PaiementLivraisonDto(){
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
    public String getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(String dateLivraison){
        this.dateLivraison = dateLivraison;
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


    public LivraisonDto getLivraison(){
        return this.livraison;
    }

    public void setLivraison(LivraisonDto livraison){
        this.livraison = livraison;
    }
    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }
    public ModePaiementDto getModePaiement(){
        return this.modePaiement;
    }

    public void setModePaiement(ModePaiementDto modePaiement){
        this.modePaiement = modePaiement;
    }
    public EtatPaiementLivraisonDto getEtatPaiementLivraison(){
        return this.etatPaiementLivraison;
    }

    public void setEtatPaiementLivraison(EtatPaiementLivraisonDto etatPaiementLivraison){
        this.etatPaiementLivraison = etatPaiementLivraison;
    }




}
