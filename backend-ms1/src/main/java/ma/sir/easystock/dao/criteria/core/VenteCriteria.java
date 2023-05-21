package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class VenteCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateVente;
    private LocalDateTime dateVenteFrom;
    private LocalDateTime dateVenteTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaye;
    private String totalPayeMin;
    private String totalPayeMax;
    private String description;
    private String descriptionLike;

    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private EtatVenteCriteria etatVente ;
    private List<EtatVenteCriteria> etatVentes ;


    public VenteCriteria(){}

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

    public LocalDateTime getDateVente(){
        return this.dateVente;
    }
    public void setDateVente(LocalDateTime dateVente){
        this.dateVente = dateVente;
    }
    public LocalDateTime getDateVenteFrom(){
        return this.dateVenteFrom;
    }
    public void setDateVenteFrom(LocalDateTime dateVenteFrom){
        this.dateVenteFrom = dateVenteFrom;
    }
    public LocalDateTime getDateVenteTo(){
        return this.dateVenteTo;
    }
    public void setDateVenteTo(LocalDateTime dateVenteTo){
        this.dateVenteTo = dateVenteTo;
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
      
    public String getTotalPaye(){
        return this.totalPaye;
    }
    public void setTotalPaye(String totalPaye){
        this.totalPaye = totalPaye;
    }   
    public String getTotalPayeMin(){
        return this.totalPayeMin;
    }
    public void setTotalPayeMin(String totalPayeMin){
        this.totalPayeMin = totalPayeMin;
    }
    public String getTotalPayeMax(){
        return this.totalPayeMax;
    }
    public void setTotalPayeMax(String totalPayeMax){
        this.totalPayeMax = totalPayeMax;
    }
      
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public StoreCriteria getStore(){
        return this.store;
    }

    public void setStore(StoreCriteria store){
        this.store = store;
    }
    public List<StoreCriteria> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreCriteria> stores){
        this.stores = stores;
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
    public EtatVenteCriteria getEtatVente(){
        return this.etatVente;
    }

    public void setEtatVente(EtatVenteCriteria etatVente){
        this.etatVente = etatVente;
    }
    public List<EtatVenteCriteria> getEtatVentes(){
        return this.etatVentes;
    }

    public void setEtatVentes(List<EtatVenteCriteria> etatVentes){
        this.etatVentes = etatVentes;
    }
}
