package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BilanDto  extends AuditBaseDto {

    private String ref  ;
    private Integer annee  = 0 ;
    private BigDecimal immobilisationsIncorporelles  ;
    private BigDecimal immobilisationsCorporelles  ;
    private BigDecimal immobilisationsFinancieres  ;
    private BigDecimal totalActifImmobolise  ;
    private BigDecimal stocks  ;
    private BigDecimal creancesClients  ;
    private BigDecimal totalActifCirculant  ;
    private BigDecimal depotEnBanque  ;
    private BigDecimal avoirEnCaisse  ;
    private BigDecimal totalTresorieActif  ;
    private BigDecimal totalActif  ;
    private BigDecimal capitalPersonnel  ;
    private BigDecimal emprunts  ;
    private BigDecimal resultat  ;
    private BigDecimal totalFinnancementPermanant  ;
    private BigDecimal dettesFournisseurs  ;
    private BigDecimal autresDettesCirculantes  ;
    private BigDecimal totalPassifCirculant  ;
    private BigDecimal totalPassif  ;

    private SocieteDto societe ;



    public BilanDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getImmobilisationsIncorporelles(){
        return this.immobilisationsIncorporelles;
    }
    public void setImmobilisationsIncorporelles(BigDecimal immobilisationsIncorporelles){
        this.immobilisationsIncorporelles = immobilisationsIncorporelles;
    }

    @Log
    public BigDecimal getImmobilisationsCorporelles(){
        return this.immobilisationsCorporelles;
    }
    public void setImmobilisationsCorporelles(BigDecimal immobilisationsCorporelles){
        this.immobilisationsCorporelles = immobilisationsCorporelles;
    }

    @Log
    public BigDecimal getImmobilisationsFinancieres(){
        return this.immobilisationsFinancieres;
    }
    public void setImmobilisationsFinancieres(BigDecimal immobilisationsFinancieres){
        this.immobilisationsFinancieres = immobilisationsFinancieres;
    }

    @Log
    public BigDecimal getTotalActifImmobolise(){
        return this.totalActifImmobolise;
    }
    public void setTotalActifImmobolise(BigDecimal totalActifImmobolise){
        this.totalActifImmobolise = totalActifImmobolise;
    }

    @Log
    public BigDecimal getStocks(){
        return this.stocks;
    }
    public void setStocks(BigDecimal stocks){
        this.stocks = stocks;
    }

    @Log
    public BigDecimal getCreancesClients(){
        return this.creancesClients;
    }
    public void setCreancesClients(BigDecimal creancesClients){
        this.creancesClients = creancesClients;
    }

    @Log
    public BigDecimal getTotalActifCirculant(){
        return this.totalActifCirculant;
    }
    public void setTotalActifCirculant(BigDecimal totalActifCirculant){
        this.totalActifCirculant = totalActifCirculant;
    }

    @Log
    public BigDecimal getDepotEnBanque(){
        return this.depotEnBanque;
    }
    public void setDepotEnBanque(BigDecimal depotEnBanque){
        this.depotEnBanque = depotEnBanque;
    }

    @Log
    public BigDecimal getAvoirEnCaisse(){
        return this.avoirEnCaisse;
    }
    public void setAvoirEnCaisse(BigDecimal avoirEnCaisse){
        this.avoirEnCaisse = avoirEnCaisse;
    }

    @Log
    public BigDecimal getTotalTresorieActif(){
        return this.totalTresorieActif;
    }
    public void setTotalTresorieActif(BigDecimal totalTresorieActif){
        this.totalTresorieActif = totalTresorieActif;
    }

    @Log
    public BigDecimal getTotalActif(){
        return this.totalActif;
    }
    public void setTotalActif(BigDecimal totalActif){
        this.totalActif = totalActif;
    }

    @Log
    public BigDecimal getCapitalPersonnel(){
        return this.capitalPersonnel;
    }
    public void setCapitalPersonnel(BigDecimal capitalPersonnel){
        this.capitalPersonnel = capitalPersonnel;
    }

    @Log
    public BigDecimal getEmprunts(){
        return this.emprunts;
    }
    public void setEmprunts(BigDecimal emprunts){
        this.emprunts = emprunts;
    }

    @Log
    public BigDecimal getResultat(){
        return this.resultat;
    }
    public void setResultat(BigDecimal resultat){
        this.resultat = resultat;
    }

    @Log
    public BigDecimal getTotalFinnancementPermanant(){
        return this.totalFinnancementPermanant;
    }
    public void setTotalFinnancementPermanant(BigDecimal totalFinnancementPermanant){
        this.totalFinnancementPermanant = totalFinnancementPermanant;
    }

    @Log
    public BigDecimal getDettesFournisseurs(){
        return this.dettesFournisseurs;
    }
    public void setDettesFournisseurs(BigDecimal dettesFournisseurs){
        this.dettesFournisseurs = dettesFournisseurs;
    }

    @Log
    public BigDecimal getAutresDettesCirculantes(){
        return this.autresDettesCirculantes;
    }
    public void setAutresDettesCirculantes(BigDecimal autresDettesCirculantes){
        this.autresDettesCirculantes = autresDettesCirculantes;
    }

    @Log
    public BigDecimal getTotalPassifCirculant(){
        return this.totalPassifCirculant;
    }
    public void setTotalPassifCirculant(BigDecimal totalPassifCirculant){
        this.totalPassifCirculant = totalPassifCirculant;
    }

    @Log
    public BigDecimal getTotalPassif(){
        return this.totalPassif;
    }
    public void setTotalPassif(BigDecimal totalPassif){
        this.totalPassif = totalPassif;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }




}
