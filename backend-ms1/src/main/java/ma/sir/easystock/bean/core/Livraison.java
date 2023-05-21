package ma.sir.easystock.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.easystock.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "livraison")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="livraison_seq",sequenceName="livraison_seq",allocationSize=1, initialValue = 1)
public class Livraison   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateLivraison ;

    private Demande demande ;
    
    private EtatLivraison etatLivraison ;
    
    private Client client ;
    

    private List<LivraisonItem> livraisonItems ;

    public Livraison(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="livraison_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Demande getDemande(){
        return this.demande;
    }
    public void setDemande(Demande demande){
        this.demande = demande;
    }
    public LocalDateTime getDateLivraison(){
        return this.dateLivraison;
    }
    public void setDateLivraison(LocalDateTime dateLivraison){
        this.dateLivraison = dateLivraison;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatLivraison getEtatLivraison(){
        return this.etatLivraison;
    }
    public void setEtatLivraison(EtatLivraison etatLivraison){
        this.etatLivraison = etatLivraison;
    }
    @OneToMany(mappedBy = "livraison")
    public List<LivraisonItem> getLivraisonItems(){
        return this.livraisonItems;
    }
    public void setLivraisonItems(List<LivraisonItem> livraisonItems){
        this.livraisonItems = livraisonItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livraison livraison = (Livraison) o;
        return id != null && id.equals(livraison.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

