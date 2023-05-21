package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirVenteItemDto  extends AuditBaseDto {

    private BigDecimal montantAvoir  ;
    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private AvoirVenteDto avoirVente ;



    public AvoirVenteItemDto(){
        super();
    }



    @Log
    public BigDecimal getMontantAvoir(){
        return this.montantAvoir;
    }
    public void setMontantAvoir(BigDecimal montantAvoir){
        this.montantAvoir = montantAvoir;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public AvoirVenteDto getAvoirVente(){
        return this.avoirVente;
    }

    public void setAvoirVente(AvoirVenteDto avoirVente){
        this.avoirVente = avoirVente;
    }




}
