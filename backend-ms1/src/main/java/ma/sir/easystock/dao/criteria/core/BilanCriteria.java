package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;

public class BilanCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private String immobilisationsIncorporelles;
    private String immobilisationsIncorporellesMin;
    private String immobilisationsIncorporellesMax;
    private String immobilisationsCorporelles;
    private String immobilisationsCorporellesMin;
    private String immobilisationsCorporellesMax;
    private String immobilisationsFinancieres;
    private String immobilisationsFinancieresMin;
    private String immobilisationsFinancieresMax;
    private String totalActifImmobolise;
    private String totalActifImmoboliseMin;
    private String totalActifImmoboliseMax;
    private String stocks;
    private String stocksMin;
    private String stocksMax;
    private String creancesClients;
    private String creancesClientsMin;
    private String creancesClientsMax;
    private String totalActifCirculant;
    private String totalActifCirculantMin;
    private String totalActifCirculantMax;
    private String depotEnBanque;
    private String depotEnBanqueMin;
    private String depotEnBanqueMax;
    private String avoirEnCaisse;
    private String avoirEnCaisseMin;
    private String avoirEnCaisseMax;
    private String totalTresorieActif;
    private String totalTresorieActifMin;
    private String totalTresorieActifMax;
    private String totalActif;
    private String totalActifMin;
    private String totalActifMax;
    private String capitalPersonnel;
    private String capitalPersonnelMin;
    private String capitalPersonnelMax;
    private String emprunts;
    private String empruntsMin;
    private String empruntsMax;
    private String resultat;
    private String resultatMin;
    private String resultatMax;
    private String totalFinnancementPermanant;
    private String totalFinnancementPermanantMin;
    private String totalFinnancementPermanantMax;
    private String dettesFournisseurs;
    private String dettesFournisseursMin;
    private String dettesFournisseursMax;
    private String autresDettesCirculantes;
    private String autresDettesCirculantesMin;
    private String autresDettesCirculantesMax;
    private String totalPassifCirculant;
    private String totalPassifCirculantMin;
    private String totalPassifCirculantMax;
    private String totalPassif;
    private String totalPassifMin;
    private String totalPassifMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;


    public BilanCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public String getImmobilisationsIncorporelles(){
        return this.immobilisationsIncorporelles;
    }
    public void setImmobilisationsIncorporelles(String immobilisationsIncorporelles){
        this.immobilisationsIncorporelles = immobilisationsIncorporelles;
    }   
    public String getImmobilisationsIncorporellesMin(){
        return this.immobilisationsIncorporellesMin;
    }
    public void setImmobilisationsIncorporellesMin(String immobilisationsIncorporellesMin){
        this.immobilisationsIncorporellesMin = immobilisationsIncorporellesMin;
    }
    public String getImmobilisationsIncorporellesMax(){
        return this.immobilisationsIncorporellesMax;
    }
    public void setImmobilisationsIncorporellesMax(String immobilisationsIncorporellesMax){
        this.immobilisationsIncorporellesMax = immobilisationsIncorporellesMax;
    }
      
    public String getImmobilisationsCorporelles(){
        return this.immobilisationsCorporelles;
    }
    public void setImmobilisationsCorporelles(String immobilisationsCorporelles){
        this.immobilisationsCorporelles = immobilisationsCorporelles;
    }   
    public String getImmobilisationsCorporellesMin(){
        return this.immobilisationsCorporellesMin;
    }
    public void setImmobilisationsCorporellesMin(String immobilisationsCorporellesMin){
        this.immobilisationsCorporellesMin = immobilisationsCorporellesMin;
    }
    public String getImmobilisationsCorporellesMax(){
        return this.immobilisationsCorporellesMax;
    }
    public void setImmobilisationsCorporellesMax(String immobilisationsCorporellesMax){
        this.immobilisationsCorporellesMax = immobilisationsCorporellesMax;
    }
      
    public String getImmobilisationsFinancieres(){
        return this.immobilisationsFinancieres;
    }
    public void setImmobilisationsFinancieres(String immobilisationsFinancieres){
        this.immobilisationsFinancieres = immobilisationsFinancieres;
    }   
    public String getImmobilisationsFinancieresMin(){
        return this.immobilisationsFinancieresMin;
    }
    public void setImmobilisationsFinancieresMin(String immobilisationsFinancieresMin){
        this.immobilisationsFinancieresMin = immobilisationsFinancieresMin;
    }
    public String getImmobilisationsFinancieresMax(){
        return this.immobilisationsFinancieresMax;
    }
    public void setImmobilisationsFinancieresMax(String immobilisationsFinancieresMax){
        this.immobilisationsFinancieresMax = immobilisationsFinancieresMax;
    }
      
    public String getTotalActifImmobolise(){
        return this.totalActifImmobolise;
    }
    public void setTotalActifImmobolise(String totalActifImmobolise){
        this.totalActifImmobolise = totalActifImmobolise;
    }   
    public String getTotalActifImmoboliseMin(){
        return this.totalActifImmoboliseMin;
    }
    public void setTotalActifImmoboliseMin(String totalActifImmoboliseMin){
        this.totalActifImmoboliseMin = totalActifImmoboliseMin;
    }
    public String getTotalActifImmoboliseMax(){
        return this.totalActifImmoboliseMax;
    }
    public void setTotalActifImmoboliseMax(String totalActifImmoboliseMax){
        this.totalActifImmoboliseMax = totalActifImmoboliseMax;
    }
      
    public String getStocks(){
        return this.stocks;
    }
    public void setStocks(String stocks){
        this.stocks = stocks;
    }   
    public String getStocksMin(){
        return this.stocksMin;
    }
    public void setStocksMin(String stocksMin){
        this.stocksMin = stocksMin;
    }
    public String getStocksMax(){
        return this.stocksMax;
    }
    public void setStocksMax(String stocksMax){
        this.stocksMax = stocksMax;
    }
      
    public String getCreancesClients(){
        return this.creancesClients;
    }
    public void setCreancesClients(String creancesClients){
        this.creancesClients = creancesClients;
    }   
    public String getCreancesClientsMin(){
        return this.creancesClientsMin;
    }
    public void setCreancesClientsMin(String creancesClientsMin){
        this.creancesClientsMin = creancesClientsMin;
    }
    public String getCreancesClientsMax(){
        return this.creancesClientsMax;
    }
    public void setCreancesClientsMax(String creancesClientsMax){
        this.creancesClientsMax = creancesClientsMax;
    }
      
    public String getTotalActifCirculant(){
        return this.totalActifCirculant;
    }
    public void setTotalActifCirculant(String totalActifCirculant){
        this.totalActifCirculant = totalActifCirculant;
    }   
    public String getTotalActifCirculantMin(){
        return this.totalActifCirculantMin;
    }
    public void setTotalActifCirculantMin(String totalActifCirculantMin){
        this.totalActifCirculantMin = totalActifCirculantMin;
    }
    public String getTotalActifCirculantMax(){
        return this.totalActifCirculantMax;
    }
    public void setTotalActifCirculantMax(String totalActifCirculantMax){
        this.totalActifCirculantMax = totalActifCirculantMax;
    }
      
    public String getDepotEnBanque(){
        return this.depotEnBanque;
    }
    public void setDepotEnBanque(String depotEnBanque){
        this.depotEnBanque = depotEnBanque;
    }   
    public String getDepotEnBanqueMin(){
        return this.depotEnBanqueMin;
    }
    public void setDepotEnBanqueMin(String depotEnBanqueMin){
        this.depotEnBanqueMin = depotEnBanqueMin;
    }
    public String getDepotEnBanqueMax(){
        return this.depotEnBanqueMax;
    }
    public void setDepotEnBanqueMax(String depotEnBanqueMax){
        this.depotEnBanqueMax = depotEnBanqueMax;
    }
      
    public String getAvoirEnCaisse(){
        return this.avoirEnCaisse;
    }
    public void setAvoirEnCaisse(String avoirEnCaisse){
        this.avoirEnCaisse = avoirEnCaisse;
    }   
    public String getAvoirEnCaisseMin(){
        return this.avoirEnCaisseMin;
    }
    public void setAvoirEnCaisseMin(String avoirEnCaisseMin){
        this.avoirEnCaisseMin = avoirEnCaisseMin;
    }
    public String getAvoirEnCaisseMax(){
        return this.avoirEnCaisseMax;
    }
    public void setAvoirEnCaisseMax(String avoirEnCaisseMax){
        this.avoirEnCaisseMax = avoirEnCaisseMax;
    }
      
    public String getTotalTresorieActif(){
        return this.totalTresorieActif;
    }
    public void setTotalTresorieActif(String totalTresorieActif){
        this.totalTresorieActif = totalTresorieActif;
    }   
    public String getTotalTresorieActifMin(){
        return this.totalTresorieActifMin;
    }
    public void setTotalTresorieActifMin(String totalTresorieActifMin){
        this.totalTresorieActifMin = totalTresorieActifMin;
    }
    public String getTotalTresorieActifMax(){
        return this.totalTresorieActifMax;
    }
    public void setTotalTresorieActifMax(String totalTresorieActifMax){
        this.totalTresorieActifMax = totalTresorieActifMax;
    }
      
    public String getTotalActif(){
        return this.totalActif;
    }
    public void setTotalActif(String totalActif){
        this.totalActif = totalActif;
    }   
    public String getTotalActifMin(){
        return this.totalActifMin;
    }
    public void setTotalActifMin(String totalActifMin){
        this.totalActifMin = totalActifMin;
    }
    public String getTotalActifMax(){
        return this.totalActifMax;
    }
    public void setTotalActifMax(String totalActifMax){
        this.totalActifMax = totalActifMax;
    }
      
    public String getCapitalPersonnel(){
        return this.capitalPersonnel;
    }
    public void setCapitalPersonnel(String capitalPersonnel){
        this.capitalPersonnel = capitalPersonnel;
    }   
    public String getCapitalPersonnelMin(){
        return this.capitalPersonnelMin;
    }
    public void setCapitalPersonnelMin(String capitalPersonnelMin){
        this.capitalPersonnelMin = capitalPersonnelMin;
    }
    public String getCapitalPersonnelMax(){
        return this.capitalPersonnelMax;
    }
    public void setCapitalPersonnelMax(String capitalPersonnelMax){
        this.capitalPersonnelMax = capitalPersonnelMax;
    }
      
    public String getEmprunts(){
        return this.emprunts;
    }
    public void setEmprunts(String emprunts){
        this.emprunts = emprunts;
    }   
    public String getEmpruntsMin(){
        return this.empruntsMin;
    }
    public void setEmpruntsMin(String empruntsMin){
        this.empruntsMin = empruntsMin;
    }
    public String getEmpruntsMax(){
        return this.empruntsMax;
    }
    public void setEmpruntsMax(String empruntsMax){
        this.empruntsMax = empruntsMax;
    }
      
    public String getResultat(){
        return this.resultat;
    }
    public void setResultat(String resultat){
        this.resultat = resultat;
    }   
    public String getResultatMin(){
        return this.resultatMin;
    }
    public void setResultatMin(String resultatMin){
        this.resultatMin = resultatMin;
    }
    public String getResultatMax(){
        return this.resultatMax;
    }
    public void setResultatMax(String resultatMax){
        this.resultatMax = resultatMax;
    }
      
    public String getTotalFinnancementPermanant(){
        return this.totalFinnancementPermanant;
    }
    public void setTotalFinnancementPermanant(String totalFinnancementPermanant){
        this.totalFinnancementPermanant = totalFinnancementPermanant;
    }   
    public String getTotalFinnancementPermanantMin(){
        return this.totalFinnancementPermanantMin;
    }
    public void setTotalFinnancementPermanantMin(String totalFinnancementPermanantMin){
        this.totalFinnancementPermanantMin = totalFinnancementPermanantMin;
    }
    public String getTotalFinnancementPermanantMax(){
        return this.totalFinnancementPermanantMax;
    }
    public void setTotalFinnancementPermanantMax(String totalFinnancementPermanantMax){
        this.totalFinnancementPermanantMax = totalFinnancementPermanantMax;
    }
      
    public String getDettesFournisseurs(){
        return this.dettesFournisseurs;
    }
    public void setDettesFournisseurs(String dettesFournisseurs){
        this.dettesFournisseurs = dettesFournisseurs;
    }   
    public String getDettesFournisseursMin(){
        return this.dettesFournisseursMin;
    }
    public void setDettesFournisseursMin(String dettesFournisseursMin){
        this.dettesFournisseursMin = dettesFournisseursMin;
    }
    public String getDettesFournisseursMax(){
        return this.dettesFournisseursMax;
    }
    public void setDettesFournisseursMax(String dettesFournisseursMax){
        this.dettesFournisseursMax = dettesFournisseursMax;
    }
      
    public String getAutresDettesCirculantes(){
        return this.autresDettesCirculantes;
    }
    public void setAutresDettesCirculantes(String autresDettesCirculantes){
        this.autresDettesCirculantes = autresDettesCirculantes;
    }   
    public String getAutresDettesCirculantesMin(){
        return this.autresDettesCirculantesMin;
    }
    public void setAutresDettesCirculantesMin(String autresDettesCirculantesMin){
        this.autresDettesCirculantesMin = autresDettesCirculantesMin;
    }
    public String getAutresDettesCirculantesMax(){
        return this.autresDettesCirculantesMax;
    }
    public void setAutresDettesCirculantesMax(String autresDettesCirculantesMax){
        this.autresDettesCirculantesMax = autresDettesCirculantesMax;
    }
      
    public String getTotalPassifCirculant(){
        return this.totalPassifCirculant;
    }
    public void setTotalPassifCirculant(String totalPassifCirculant){
        this.totalPassifCirculant = totalPassifCirculant;
    }   
    public String getTotalPassifCirculantMin(){
        return this.totalPassifCirculantMin;
    }
    public void setTotalPassifCirculantMin(String totalPassifCirculantMin){
        this.totalPassifCirculantMin = totalPassifCirculantMin;
    }
    public String getTotalPassifCirculantMax(){
        return this.totalPassifCirculantMax;
    }
    public void setTotalPassifCirculantMax(String totalPassifCirculantMax){
        this.totalPassifCirculantMax = totalPassifCirculantMax;
    }
      
    public String getTotalPassif(){
        return this.totalPassif;
    }
    public void setTotalPassif(String totalPassif){
        this.totalPassif = totalPassif;
    }   
    public String getTotalPassifMin(){
        return this.totalPassifMin;
    }
    public void setTotalPassifMin(String totalPassifMin){
        this.totalPassifMin = totalPassifMin;
    }
    public String getTotalPassifMax(){
        return this.totalPassifMax;
    }
    public void setTotalPassifMax(String totalPassifMax){
        this.totalPassifMax = totalPassifMax;
    }
      

    public SocieteCriteria getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteCriteria societe){
        this.societe = societe;
    }
    public List<SocieteCriteria> getSocietes(){
        return this.societes;
    }

    public void setSocietes(List<SocieteCriteria> societes){
        this.societes = societes;
    }
}
