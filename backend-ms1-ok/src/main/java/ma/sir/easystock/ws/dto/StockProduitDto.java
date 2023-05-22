package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockProduitDto  extends AuditBaseDto {

    private BigDecimal quantite  ;
    private BigDecimal quantiteDeffecteuse  ;

    private MagasinDto magasin ;
    private ProduitDto produit ;



    public StockProduitDto(){
        super();
    }



    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getQuantiteDeffecteuse(){
        return this.quantiteDeffecteuse;
    }
    public void setQuantiteDeffecteuse(BigDecimal quantiteDeffecteuse){
        this.quantiteDeffecteuse = quantiteDeffecteuse;
    }


    public MagasinDto getMagasin(){
        return this.magasin;
    }

    public void setMagasin(MagasinDto magasin){
        this.magasin = magasin;
    }
    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }




}
