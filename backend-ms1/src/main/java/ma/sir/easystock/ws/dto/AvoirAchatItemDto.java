package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AvoirAchatItemDto  extends AuditBaseDto {

    private BigDecimal montant  ;
    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private AvoirAchatDto avoirAchat ;



    public AvoirAchatItemDto(){
        super();
    }



    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
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
    public AvoirAchatDto getAvoirAchat(){
        return this.avoirAchat;
    }

    public void setAvoirAchat(AvoirAchatDto avoirAchat){
        this.avoirAchat = avoirAchat;
    }




}
