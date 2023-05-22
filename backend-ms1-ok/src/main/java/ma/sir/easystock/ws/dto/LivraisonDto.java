package  ma.sir.easystock.ws.dto;

import ma.sir.easystock.zynerator.audit.Log;
import ma.sir.easystock.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class LivraisonDto  extends AuditBaseDto {

    private String dateLivraison ;

    private DemandeDto demande ;
    private EtatLivraisonDto etatLivraison ;
    private ClientDto client ;

    private List<LivraisonItemDto> livraisonItems ;


    public LivraisonDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(String dateLivraison){
        this.dateLivraison = dateLivraison;
    }


    public DemandeDto getDemande(){
        return this.demande;
    }

    public void setDemande(DemandeDto demande){
        this.demande = demande;
    }
    public EtatLivraisonDto getEtatLivraison(){
        return this.etatLivraison;
    }

    public void setEtatLivraison(EtatLivraisonDto etatLivraison){
        this.etatLivraison = etatLivraison;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<LivraisonItemDto> getLivraisonItems(){
        return this.livraisonItems;
    }

    public void setLivraisonItems(List<LivraisonItemDto> livraisonItems){
        this.livraisonItems = livraisonItems;
    }

}
