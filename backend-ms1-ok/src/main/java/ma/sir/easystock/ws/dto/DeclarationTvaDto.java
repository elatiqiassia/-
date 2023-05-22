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
public class DeclarationTvaDto  extends AuditBaseDto {

    private String reference  ;
    private String dateDeclaration ;
    private Integer trimistre  = 0 ;
    private Integer annee  = 0 ;
    private BigDecimal totalTvaCollecte  ;
    private BigDecimal totalTvaDue  ;
    private BigDecimal differenceTva  ;
    private BigDecimal montantTva  ;

    private SocieteDto societe ;
    private TauxRetardTvaDto tauxRetardTva ;
    private ComptableTraitantDto comptableTraitant ;
    private ComptableValidateurDto comptableValidateur ;



    public DeclarationTvaDto(){
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
    public String getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(String dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }

    @Log
    public Integer getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(Integer trimistre){
        this.trimistre = trimistre;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getTotalTvaCollecte(){
        return this.totalTvaCollecte;
    }
    public void setTotalTvaCollecte(BigDecimal totalTvaCollecte){
        this.totalTvaCollecte = totalTvaCollecte;
    }

    @Log
    public BigDecimal getTotalTvaDue(){
        return this.totalTvaDue;
    }
    public void setTotalTvaDue(BigDecimal totalTvaDue){
        this.totalTvaDue = totalTvaDue;
    }

    @Log
    public BigDecimal getDifferenceTva(){
        return this.differenceTva;
    }
    public void setDifferenceTva(BigDecimal differenceTva){
        this.differenceTva = differenceTva;
    }

    @Log
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }
    public TauxRetardTvaDto getTauxRetardTva(){
        return this.tauxRetardTva;
    }

    public void setTauxRetardTva(TauxRetardTvaDto tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
    }
    public ComptableTraitantDto getComptableTraitant(){
        return this.comptableTraitant;
    }

    public void setComptableTraitant(ComptableTraitantDto comptableTraitant){
        this.comptableTraitant = comptableTraitant;
    }
    public ComptableValidateurDto getComptableValidateur(){
        return this.comptableValidateur;
    }

    public void setComptableValidateur(ComptableValidateurDto comptableValidateur){
        this.comptableValidateur = comptableValidateur;
    }




}
