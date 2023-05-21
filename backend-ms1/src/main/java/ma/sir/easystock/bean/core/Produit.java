package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="produit_seq",sequenceName="produit_seq",allocationSize=1, initialValue = 1)
public class Produit   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String barcode;
    @Column(length = 500)
    private String description;
    private BigDecimal prixAchatMoyen = BigDecimal.ZERO;
    private BigDecimal quantite = BigDecimal.ZERO;
    private BigDecimal seuilAlert = BigDecimal.ZERO;
    @Column(length = 500)
    private String photoProduits;

    private CategorieProduit categorieProduit ;
    
    private UniteMesure uniteMesure ;
    
    private Marque marque ;
    
    private Store store ;
    


    public Produit(){
        super();
    }

    public Produit(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CategorieProduit getCategorieProduit(){
        return this.categorieProduit;
    }
    public void setCategorieProduit(CategorieProduit categorieProduit){
        this.categorieProduit = categorieProduit;
    }
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public BigDecimal getPrixAchatMoyen(){
        return this.prixAchatMoyen;
    }
    public void setPrixAchatMoyen(BigDecimal prixAchatMoyen){
        this.prixAchatMoyen = prixAchatMoyen;
    }
    public BigDecimal getQuantite(){
        return this.quantite;
    }
    public void setQuantite(BigDecimal quantite){
        this.quantite = quantite;
    }
    public BigDecimal getSeuilAlert(){
        return this.seuilAlert;
    }
    public void setSeuilAlert(BigDecimal seuilAlert){
        this.seuilAlert = seuilAlert;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public UniteMesure getUniteMesure(){
        return this.uniteMesure;
    }
    public void setUniteMesure(UniteMesure uniteMesure){
        this.uniteMesure = uniteMesure;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Marque getMarque(){
        return this.marque;
    }
    public void setMarque(Marque marque){
        this.marque = marque;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public String getPhotoProduits(){
        return this.photoProduits;
    }
    public void setPhotoProduits(String photoProduits){
        this.photoProduits = photoProduits;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return id != null && id.equals(produit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

