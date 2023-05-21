package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommandeItemDto  extends AuditBaseDto {

    private BigDecimal prix  ;
    private BigDecimal quantite  ;
    private BigDecimal quantiteReceptionne  ;

    private ProduitDto produit ;
    private CommandeDto commande ;



    public CommandeItemDto(){
        super();
    }



    @Log
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getQuantiteReceptionne(){
        return this.quantiteReceptionne;
    }
    public void setQuantiteReceptionne(BigDecimal quantiteReceptionne){
        this.quantiteReceptionne = quantiteReceptionne;
    }


    public ProduitDto getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitDto produit){
        this.produit = produit;
    }
    public CommandeDto getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeDto commande){
        this.commande = commande;
    }




}
