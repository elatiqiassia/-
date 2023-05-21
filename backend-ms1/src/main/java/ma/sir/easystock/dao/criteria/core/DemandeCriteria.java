package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DemandeCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateCommande;
    private LocalDateTime dateCommandeFrom;
    private LocalDateTime dateCommandeTo;
    private String totalCheque;
    private String totalChequeMin;
    private String totalChequeMax;
    private String totalEspece;
    private String totalEspeceMin;
    private String totalEspeceMax;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalePaye;
    private String totalePayeMin;
    private String totalePayeMax;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private EtatDemandeCriteria etatDemande ;
    private List<EtatDemandeCriteria> etatDemandes ;


    public DemandeCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDateCommande(){
        return this.dateCommande;
    }
    public void setDateCommande(LocalDateTime dateCommande){
        this.dateCommande = dateCommande;
    }
    public LocalDateTime getDateCommandeFrom(){
        return this.dateCommandeFrom;
    }
    public void setDateCommandeFrom(LocalDateTime dateCommandeFrom){
        this.dateCommandeFrom = dateCommandeFrom;
    }
    public LocalDateTime getDateCommandeTo(){
        return this.dateCommandeTo;
    }
    public void setDateCommandeTo(LocalDateTime dateCommandeTo){
        this.dateCommandeTo = dateCommandeTo;
    }
    public String getTotalCheque(){
        return this.totalCheque;
    }
    public void setTotalCheque(String totalCheque){
        this.totalCheque = totalCheque;
    }   
    public String getTotalChequeMin(){
        return this.totalChequeMin;
    }
    public void setTotalChequeMin(String totalChequeMin){
        this.totalChequeMin = totalChequeMin;
    }
    public String getTotalChequeMax(){
        return this.totalChequeMax;
    }
    public void setTotalChequeMax(String totalChequeMax){
        this.totalChequeMax = totalChequeMax;
    }
      
    public String getTotalEspece(){
        return this.totalEspece;
    }
    public void setTotalEspece(String totalEspece){
        this.totalEspece = totalEspece;
    }   
    public String getTotalEspeceMin(){
        return this.totalEspeceMin;
    }
    public void setTotalEspeceMin(String totalEspeceMin){
        this.totalEspeceMin = totalEspeceMin;
    }
    public String getTotalEspeceMax(){
        return this.totalEspeceMax;
    }
    public void setTotalEspeceMax(String totalEspeceMax){
        this.totalEspeceMax = totalEspeceMax;
    }
      
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getTotalePaye(){
        return this.totalePaye;
    }
    public void setTotalePaye(String totalePaye){
        this.totalePaye = totalePaye;
    }   
    public String getTotalePayeMin(){
        return this.totalePayeMin;
    }
    public void setTotalePayeMin(String totalePayeMin){
        this.totalePayeMin = totalePayeMin;
    }
    public String getTotalePayeMax(){
        return this.totalePayeMax;
    }
    public void setTotalePayeMax(String totalePayeMax){
        this.totalePayeMax = totalePayeMax;
    }
      

    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public EtatDemandeCriteria getEtatDemande(){
        return this.etatDemande;
    }

    public void setEtatDemande(EtatDemandeCriteria etatDemande){
        this.etatDemande = etatDemande;
    }
    public List<EtatDemandeCriteria> getEtatDemandes(){
        return this.etatDemandes;
    }

    public void setEtatDemandes(List<EtatDemandeCriteria> etatDemandes){
        this.etatDemandes = etatDemandes;
    }
}
