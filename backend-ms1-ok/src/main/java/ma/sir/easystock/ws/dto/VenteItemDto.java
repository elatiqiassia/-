package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VenteItemDto  extends AuditBaseDto {

    private BigDecimal prixUnitaire  ;
    private BigDecimal quantite  ;
    private BigDecimal remise  ;
    private BigDecimal quantiteAvoir  ;

    private ProduitDto produit ;
    private VenteDto vente ;



    public VenteItemDto(){
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

    @Log
    public BigDecimal getQuantiteAvoir(){
        return this.quantiteAvoir;
    }
    public void setQuantiteAvoir(BigDecimal quantiteAvoir){
        this.quantiteAvoir = quantiteAvoir;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public VenteDto getVente(){
        return this.vente;
    }

    public void setVente(VenteDto vente){
        this.vente = vente;
    }




}
