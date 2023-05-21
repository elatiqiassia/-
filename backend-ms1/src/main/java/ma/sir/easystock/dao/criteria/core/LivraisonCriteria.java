package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class LivraisonCriteria extends  BaseCriteria  {

    private LocalDateTime dateLivraison;
    private LocalDateTime dateLivraisonFrom;
    private LocalDateTime dateLivraisonTo;

    private DemandeCriteria demande ;
    private List<DemandeCriteria> demandes ;
    private EtatLivraisonCriteria etatLivraison ;
    private List<EtatLivraisonCriteria> etatLivraisons ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;


    public LivraisonCriteria(){}

    public LocalDateTime getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(LocalDateTime dateLivraison){
        this.dateLivraison = dateLivraison;
    }
    public LocalDateTime getDateLivraisonFrom(){
        return this.dateLivraisonFrom;
    }
    public void setDateLivraisonFrom(LocalDateTime dateLivraisonFrom){
        this.dateLivraisonFrom = dateLivraisonFrom;
    }
    public LocalDateTime getDateLivraisonTo(){
        return this.dateLivraisonTo;
    }
    public void setDateLivraisonTo(LocalDateTime dateLivraisonTo){
        this.dateLivraisonTo = dateLivraisonTo;
    }

    public DemandeCriteria getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeCriteria demande){
        this.demande = demande;
    }
    public List<DemandeCriteria> getDemandes(){
        return this.demandes;
    }

    public void setDemandes(List<DemandeCriteria> demandes){
        this.demandes = demandes;
    }
    public EtatLivraisonCriteria getEtatLivraison(){
        return this.etatLivraison;
    }

    public void setEtatLivraison(EtatLivraisonCriteria etatLivraison){
        this.etatLivraison = etatLivraison;
    }
    public List<EtatLivraisonCriteria> getEtatLivraisons(){
        return this.etatLivraisons;
    }

    public void setEtatLivraisons(List<EtatLivraisonCriteria> etatLivraisons){
        this.etatLivraisons = etatLivraisons;
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
}
