package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CommandeCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateCommande;
    private LocalDateTime dateCommandeFrom;
    private LocalDateTime dateCommandeTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalePaye;
    private String totalePayeMin;
    private String totalePayeMax;
    private String totalPayeCheque;
    private String totalPayeChequeMin;
    private String totalPayeChequeMax;
    private String totalPayeEspece;
    private String totalPayeEspeceMin;
    private String totalPayeEspeceMax;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private EtatCommandeCriteria etatCommande ;
    private List<EtatCommandeCriteria> etatCommandes ;


    public CommandeCriteria(){}

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
      
    public String getTotalPayeCheque(){
        return this.totalPayeCheque;
    }
    public void setTotalPayeCheque(String totalPayeCheque){
        this.totalPayeCheque = totalPayeCheque;
    }   
    public String getTotalPayeChequeMin(){
        return this.totalPayeChequeMin;
    }
    public void setTotalPayeChequeMin(String totalPayeChequeMin){
        this.totalPayeChequeMin = totalPayeChequeMin;
    }
    public String getTotalPayeChequeMax(){
        return this.totalPayeChequeMax;
    }
    public void setTotalPayeChequeMax(String totalPayeChequeMax){
        this.totalPayeChequeMax = totalPayeChequeMax;
    }
      
    public String getTotalPayeEspece(){
        return this.totalPayeEspece;
    }
    public void setTotalPayeEspece(String totalPayeEspece){
        this.totalPayeEspece = totalPayeEspece;
    }   
    public String getTotalPayeEspeceMin(){
        return this.totalPayeEspeceMin;
    }
    public void setTotalPayeEspeceMin(String totalPayeEspeceMin){
        this.totalPayeEspeceMin = totalPayeEspeceMin;
    }
    public String getTotalPayeEspeceMax(){
        return this.totalPayeEspeceMax;
    }
    public void setTotalPayeEspeceMax(String totalPayeEspeceMax){
        this.totalPayeEspeceMax = totalPayeEspeceMax;
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
    public EtatCommandeCriteria getEtatCommande(){
        return this.etatCommande;
    }

    public void setEtatCommande(EtatCommandeCriteria etatCommande){
        this.etatCommande = etatCommande;
    }
    public List<EtatCommandeCriteria> getEtatCommandes(){
        return this.etatCommandes;
    }

    public void setEtatCommandes(List<EtatCommandeCriteria> etatCommandes){
        this.etatCommandes = etatCommandes;
    }
}
