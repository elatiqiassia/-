package  ma.sir.easystock.dao.criteria.core;


import ma.sir.easystock.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReceptionCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateReception;
    private LocalDateTime dateReceptionFrom;
    private LocalDateTime dateReceptionTo;
    private String description;
    private String descriptionLike;

    private CommandeCriteria commande ;
    private List<CommandeCriteria> commandes ;
    private EtatReceptionCriteria etatReception ;
    private List<EtatReceptionCriteria> etatReceptions ;


    public ReceptionCriteria(){}

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

    public LocalDateTime getDateReception(){
        return this.dateReception;
    }
    public void setDateReception(LocalDateTime dateReception){
        this.dateReception = dateReception;
    }
    public LocalDateTime getDateReceptionFrom(){
        return this.dateReceptionFrom;
    }
    public void setDateReceptionFrom(LocalDateTime dateReceptionFrom){
        this.dateReceptionFrom = dateReceptionFrom;
    }
    public LocalDateTime getDateReceptionTo(){
        return this.dateReceptionTo;
    }
    public void setDateReceptionTo(LocalDateTime dateReceptionTo){
        this.dateReceptionTo = dateReceptionTo;
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


    public CommandeCriteria getCommande(){
        return this.commande;
    }

    public void setCommande(CommandeCriteria commande){
        this.commande = commande;
    }
    public List<CommandeCriteria> getCommandes(){
        return this.commandes;
    }

    public void setCommandes(List<CommandeCriteria> commandes){
        this.commandes = commandes;
    }
    public EtatReceptionCriteria getEtatReception(){
        return this.etatReception;
    }

    public void setEtatReception(EtatReceptionCriteria etatReception){
        this.etatReception = etatReception;
    }
    public List<EtatReceptionCriteria> getEtatReceptions(){
        return this.etatReceptions;
    }

    public void setEtatReceptions(List<EtatReceptionCriteria> etatReceptions){
        this.etatReceptions = etatReceptions;
    }
}
