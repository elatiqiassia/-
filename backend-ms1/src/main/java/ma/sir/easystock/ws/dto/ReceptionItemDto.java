package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceptionItemDto  extends AuditBaseDto {

    private BigDecimal quantite  ;

    private ProduitDto produit ;
    private MagasinDto magasin ;
    private ReceptionDto reception ;



    public ReceptionItemDto(){
        super();
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
    public MagasinDto getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinDto magasin){
        this.magasin = magasin;
    }
    public ReceptionDto getReception(){
        return this.reception;
    }

    public void setReception(ReceptionDto reception){
        this.reception = reception;
    }




}
