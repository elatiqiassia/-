package ma.sir.easystock.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "bilan")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="bilan_seq",sequenceName="bilan_seq",allocationSize=1, initialValue = 1)
public class Bilan   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private Integer annee = 0;
    private BigDecimal immobilisationsIncorporelles = BigDecimal.ZERO;
    private BigDecimal immobilisationsCorporelles = BigDecimal.ZERO;
    private BigDecimal immobilisationsFinancieres = BigDecimal.ZERO;
    private BigDecimal totalActifImmobolise = BigDecimal.ZERO;
    private BigDecimal stocks = BigDecimal.ZERO;
    private BigDecimal creancesClients = BigDecimal.ZERO;
    private BigDecimal totalActifCirculant = BigDecimal.ZERO;
    private BigDecimal depotEnBanque = BigDecimal.ZERO;
    private BigDecimal avoirEnCaisse = BigDecimal.ZERO;
    private BigDecimal totalTresorieActif = BigDecimal.ZERO;
    private BigDecimal totalActif = BigDecimal.ZERO;
    private BigDecimal capitalPersonnel = BigDecimal.ZERO;
    private BigDecimal emprunts = BigDecimal.ZERO;
    private BigDecimal resultat = BigDecimal.ZERO;
    private BigDecimal totalFinnancementPermanant = BigDecimal.ZERO;
    private BigDecimal dettesFournisseurs = BigDecimal.ZERO;
    private BigDecimal autresDettesCirculantes = BigDecimal.ZERO;
    private BigDecimal totalPassifCirculant = BigDecimal.ZERO;
    private BigDecimal totalPassif = BigDecimal.ZERO;

    private Societe societe ;
    


    public Bilan(){
        super();
    }

    public Bilan(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="bilan_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    public BigDecimal getImmobilisationsIncorporelles(){
        return this.immobilisationsIncorporelles;
    }
    public void setImmobilisationsIncorporelles(BigDecimal immobilisationsIncorporelles){
        this.immobilisationsIncorporelles = immobilisationsIncorporelles;
    }
    public BigDecimal getImmobilisationsCorporelles(){
        return this.immobilisationsCorporelles;
    }
    public void setImmobilisationsCorporelles(BigDecimal immobilisationsCorporelles){
        this.immobilisationsCorporelles = immobilisationsCorporelles;
    }
    public BigDecimal getImmobilisationsFinancieres(){
        return this.immobilisationsFinancieres;
    }
    public void setImmobilisationsFinancieres(BigDecimal immobilisationsFinancieres){
        this.immobilisationsFinancieres = immobilisationsFinancieres;
    }
    public BigDecimal getTotalActifImmobolise(){
        return this.totalActifImmobolise;
    }
    public void setTotalActifImmobolise(BigDecimal totalActifImmobolise){
        this.totalActifImmobolise = totalActifImmobolise;
    }
    public BigDecimal getStocks(){
        return this.stocks;
    }
    public void setStocks(BigDecimal stocks){
        this.stocks = stocks;
    }
    public BigDecimal getCreancesClients(){
        return this.creancesClients;
    }
    public void setCreancesClients(BigDecimal creancesClients){
        this.creancesClients = creancesClients;
    }
    public BigDecimal getTotalActifCirculant(){
        return this.totalActifCirculant;
    }
    public void setTotalActifCirculant(BigDecimal totalActifCirculant){
        this.totalActifCirculant = totalActifCirculant;
    }
    public BigDecimal getDepotEnBanque(){
        return this.depotEnBanque;
    }
    public void setDepotEnBanque(BigDecimal depotEnBanque){
        this.depotEnBanque = depotEnBanque;
    }
    public BigDecimal getAvoirEnCaisse(){
        return this.avoirEnCaisse;
    }
    public void setAvoirEnCaisse(BigDecimal avoirEnCaisse){
        this.avoirEnCaisse = avoirEnCaisse;
    }
    public BigDecimal getTotalTresorieActif(){
        return this.totalTresorieActif;
    }
    public void setTotalTresorieActif(BigDecimal totalTresorieActif){
        this.totalTresorieActif = totalTresorieActif;
    }
    public BigDecimal getTotalActif(){
        return this.totalActif;
    }
    public void setTotalActif(BigDecimal totalActif){
        this.totalActif = totalActif;
    }
    public BigDecimal getCapitalPersonnel(){
        return this.capitalPersonnel;
    }
    public void setCapitalPersonnel(BigDecimal capitalPersonnel){
        this.capitalPersonnel = capitalPersonnel;
    }
    public BigDecimal getEmprunts(){
        return this.emprunts;
    }
    public void setEmprunts(BigDecimal emprunts){
        this.emprunts = emprunts;
    }
    public BigDecimal getResultat(){
        return this.resultat;
    }
    public void setResultat(BigDecimal resultat){
        this.resultat = resultat;
    }
    public BigDecimal getTotalFinnancementPermanant(){
        return this.totalFinnancementPermanant;
    }
    public void setTotalFinnancementPermanant(BigDecimal totalFinnancementPermanant){
        this.totalFinnancementPermanant = totalFinnancementPermanant;
    }
    public BigDecimal getDettesFournisseurs(){
        return this.dettesFournisseurs;
    }
    public void setDettesFournisseurs(BigDecimal dettesFournisseurs){
        this.dettesFournisseurs = dettesFournisseurs;
    }
    public BigDecimal getAutresDettesCirculantes(){
        return this.autresDettesCirculantes;
    }
    public void setAutresDettesCirculantes(BigDecimal autresDettesCirculantes){
        this.autresDettesCirculantes = autresDettesCirculantes;
    }
    public BigDecimal getTotalPassifCirculant(){
        return this.totalPassifCirculant;
    }
    public void setTotalPassifCirculant(BigDecimal totalPassifCirculant){
        this.totalPassifCirculant = totalPassifCirculant;
    }
    public BigDecimal getTotalPassif(){
        return this.totalPassif;
    }
    public void setTotalPassif(BigDecimal totalPassif){
        this.totalPassif = totalPassif;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilan bilan = (Bilan) o;
        return id != null && id.equals(bilan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

