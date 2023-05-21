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


import java.math.BigDecimal;


@Entity
@Table(name = "avoir_achat")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="avoir_achat_seq",sequenceName="avoir_achat_seq",allocationSize=1, initialValue = 1)
public class AvoirAchat   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateAvoir ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Achat achat ;
    
    private EtatAvoirAchat etatAvoirAchat ;
    

    private List<AvoirAchatItem> avoirAchatItems ;

    public AvoirAchat(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="avoir_achat_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateAvoir(){
        return this.dateAvoir;
    }
    public void setDateAvoir(LocalDateTime dateAvoir){
        this.dateAvoir = dateAvoir;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Achat getAchat(){
        return this.achat;
    }
    public void setAchat(Achat achat){
        this.achat = achat;
    }
    @OneToMany(mappedBy = "avoirAchat")
    public List<AvoirAchatItem> getAvoirAchatItems(){
        return this.avoirAchatItems;
    }
    public void setAvoirAchatItems(List<AvoirAchatItem> avoirAchatItems){
        this.avoirAchatItems = avoirAchatItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatAvoirAchat getEtatAvoirAchat(){
        return this.etatAvoirAchat;
    }
    public void setEtatAvoirAchat(EtatAvoirAchat etatAvoirAchat){
        this.etatAvoirAchat = etatAvoirAchat;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvoirAchat avoirAchat = (AvoirAchat) o;
        return id != null && id.equals(avoirAchat.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

