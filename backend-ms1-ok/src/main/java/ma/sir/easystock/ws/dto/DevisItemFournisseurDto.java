package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DevisItemFournisseurDto  extends AuditBaseDto {

    private BigDecimal prixUnitaire  ;
    private BigDecimal quantite  ;
    private BigDecimal remise  ;

    private ProduitDto produit ;
    private DevisFournisseurDto devisFournisseur ;



    public DevisItemFournisseurDto(){
        super();
    }



    @Log
    public BigDecimal getPrixUnitaire(){
        return this.prixUnitaire;
    }
    public void setPrixUnitaire(BigDecimal prixUnitaire){
        this.prixUnitaire = prixUnitaire;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getRemise(){
        return this.remise;
    }
    public void setRemise(BigDecimal remise){
        this.remise = remise;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public DevisFournisseurDto getDevisFournisseur(){
        return this.devisFournisseur;
    }

    public void setDevisFournisseur(DevisFournisseurDto devisFournisseur){
        this.devisFournisseur = devisFournisseur;
    }




}
