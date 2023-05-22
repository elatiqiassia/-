package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProduitDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;
    private String barcode  ;
    private String description  ;
    private BigDecimal prixAchatMoyen  ;
    private BigDecimal quantite  ;
    private BigDecimal seuilAlert  ;
    private String photoProduits  ;

    private CategorieProduitDto categorieProduit ;
    private UniteMesureDto uniteMesure ;
    private MarqueDto marque ;
    private StoreDto store ;



    public ProduitDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }

    @Log
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }

    @Log
    public BigDecimal getSeuilAlert(){
        return this.seuilAlert;
    }
    public void setSeuilAlert(BigDecimal seuilAlert){
        this.seuilAlert = seuilAlert;
    }

    @Log
    public String getPhotoProduits(){
        return this.photoProduits;
    }
    public void setPhotoProduits(String photoProduits){
        this.photoProduits = photoProduits;
    }


    public CategorieProduitDto getCategorieProduit(){
        return this.categorieProduit;
    }

    public void setCategorieProduit(CategorieProduitDto categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public UniteMesureDto getUniteMesure(){
        return this.uniteMesure;
    }

    public void setUniteMesure(UniteMesureDto uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    public MarqueDto getMarque(){
        return this.marque;
    }

    public void setMarque(MarqueDto marque){
        this.marque = marque;
    }
    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }




}
